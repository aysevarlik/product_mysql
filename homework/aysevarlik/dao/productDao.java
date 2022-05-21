package aysevarlik.dao;

import aysevarlik.dto.productDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class productDao implements IDaoConnection<productDto> {


    @Override
    public void create(productDto productDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "insert into product(product_name,category,model_year,model_id) values(?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, productDto.getProductName());
            preparedStatement.setString(2,productDto.getCategory());
            preparedStatement.setString(3, String.valueOf(productDto.getModelYear()));
            preparedStatement.setString(4, String.valueOf(productDto.getModelId()));
            int rowEffected=  preparedStatement.executeUpdate();
            if(rowEffected>0){
                System.out.println("Ekleme Başarılı");
            }else{
                System.out.println("Ekleme Başarısız...");
            }

        } catch (Exception e) {
            System.out.println(productDao.class + "  Ekleme sırasında hata meydana geldi");
            e.printStackTrace();
        }
    }

    @Override
    public void update(productDto productDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "update product set product_name=?,category=?,model_year=?,model_id=? where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,productDto.getProductName());
            preparedStatement.setString(2,productDto.getCategory());
            preparedStatement.setString(3, String.valueOf(productDto.getModelYear()));
            preparedStatement.setString(4, String.valueOf(productDto.getModelId()));
            preparedStatement.setLong(5,productDto.getProductId());
            int rowEffected=  preparedStatement.executeUpdate();
            if(rowEffected>0){
                System.out.println("Güncelleme Başarılı");
            }else{
                System.out.println("Güncelleme Başarısız");
            }

        } catch (Exception e) {
            System.out.println(productDto.class + "  Ekleme sırasında hata meydana geldi");
            e.printStackTrace();
        }

    }

    @Override
    public void delete(productDto productDto) {
        try (Connection connection = getInterfaceConnection()) {
            //delete from admin where id=3;
            String sql = "delete from product where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,productDto.getProductId());
            int rowEffected=  preparedStatement.executeUpdate();
            if(rowEffected>0){
                System.out.println("Silme Başarılı");
            }else{
                System.out.println("Silme Başarısız");
            }
        } catch (Exception e) {
            System.out.println(productDto.class + "  Silme sırasında hata meydana geldi");
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<productDto> list() {
        ArrayList<productDto> listem=new ArrayList<>();
        productDto productDto;
        try (Connection connection = getInterfaceConnection()) {
            String sql = "select * from product";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                productDto=new productDto();
                productDto.setProductId(resultSet.getInt("id"));
                productDto.setProductName(resultSet.getString("product_name"));
                productDto.setCategory(resultSet.getString("category"));
                productDto.setModelYear(resultSet.getLong("model_year"));
                productDto.setModelId(resultSet.getLong("model_id"));
                productDto.setCreatedDate(resultSet.getDate("created_date"));
                listem.add(productDto);
            }
        } catch (Exception e) {
            System.out.println(productDto.class + "  Silme sırasında hata meydana geldi");
            e.printStackTrace();
        }
        return listem;
    }
}
