package oose.dea.dao;

import oose.dea.domain.Item;

import javax.inject.Inject;
import java.util.List;

public interface ItemDAO {
    @Inject
    List<Item> list();
}
