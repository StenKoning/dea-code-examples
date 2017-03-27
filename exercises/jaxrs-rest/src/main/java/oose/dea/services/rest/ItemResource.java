package oose.dea.services.rest;

/**
 * Created by alexanderstenkoning on 26/03/17.
 */


import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.List;


@Singleton
@Path("items")
public class ItemResource {
    private ArrayList<Item> items = new ArrayList<Item>();

    public ItemResource(){
        items.add(new Item("skubread", "food", "bread"));
        items.add(new Item("skubutter", "food", "butter"));
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List getTextItems(){
        return items;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getJsonItems() { return items; }

    @GET
    @Path("{itemSKU}")
    public Item getJsonItem(@PathParam("itemSKU") String sku){
        for(Item item: items){
            if(item.getSku().equals(sku))
                return item;
        }
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String addItem(MultivaluedMap<String, String> formParams){
        System.out.println(formParams);
        Item newItem = new Item(
                formParams.getFirst("sku"),
                formParams.getFirst("category"),
                formParams.getFirst("title"));

        items.add(newItem);

        return  ""+items.size();
    }
}
