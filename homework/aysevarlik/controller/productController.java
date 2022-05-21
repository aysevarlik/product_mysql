package aysevarlik.controller;

import aysevarlik.dao.IDaoConnection;
import aysevarlik.dao.productDao;
import aysevarlik.dto.productDto;

import java.util.ArrayList;

public class productController  implements IDaoConnection<productDto> {
    productDao productDao;

    public productController(){
        productDao = new productDao();
    }

    @Override
    public void create(productDto productDto) {
        this.productDao.create(productDto);

    }

    @Override
    public void update(productDto productDto) {
        this.productDao.update(productDto);

    }

    @Override
    public void delete(productDto productDto) {
        this.productDao.delete(productDto);

    }

    @Override
    public ArrayList<productDto> list() {
        return this.productDao.list();
    }
}
