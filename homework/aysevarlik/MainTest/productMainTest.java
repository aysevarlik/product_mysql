package aysevarlik.MainTest;

import aysevarlik.controller.productController;
import aysevarlik.dto.productDto;
import javax.swing.*;

public class productMainTest {
    public static void main(String[] args) {
        productController productController = new productController();

        //create:

        /*String product_name,category,model_year,model_id;
        product_name = JOptionPane.showInputDialog("ürün adı: ");
        category = JOptionPane.showInputDialog("ürün kategorisi: ");
        model_year = JOptionPane.showInputDialog("ürün model yılı: ");
        model_id = JOptionPane.showInputDialog("ürün id: ");
        productDto productDto = aysevarlik.dto.productDto.builder().ProductName(product_name).Category(category).
                ModelYear(Long.parseLong(model_year)).ModelId(Long.parseLong(model_id)).build();
        productController.create(productDto);*/


        //update

        /*String name,category,year,modelId;
        long id;
        id=Long.valueOf(JOptionPane.showInputDialog("id giriniz: "));
        name = JOptionPane.showInputDialog("güncel isim: ");
        category = JOptionPane.showInputDialog("güncel kategori: ");
        year = JOptionPane.showInputDialog("güncel yıl: ");
        modelId = JOptionPane.showInputDialog("güncel id: ");
        productDto productDto = aysevarlik.dto.productDto.builder().ProductId(id).ProductName(name).Category(category).ModelYear(Long.parseLong(year)).ModelId(Long.parseLong(modelId)).build();
        productController.update(productDto);*/



        //delete:
        long id;
        id=Long.valueOf(JOptionPane.showInputDialog("id: "));
        productDto productDto = aysevarlik.dto.productDto.builder().ProductId(id).build();
        productController.delete(productDto);

        //list
        productController.list().forEach(System.out::println);

    }
}
