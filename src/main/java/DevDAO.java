import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevDAO {

    public List<Dev> list(){
        List<Dev> devs = new ArrayList<>();

        try(Connection conexao = ConnectionBanco.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("select * from dev");
            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()){
                Dev dev = new Dev();
                dev.setId(resultado.getInt("id"));
                dev.setNome(resultado.getString("nome"));
                dev.setProjeto(resultado.getString("projeto"));
                dev.setIdade(resultado.getInt("idade"));

                devs.add(dev);
            }

        }catch (SQLException e){
            System.out.println("Erro ao tentar listar");
            e.printStackTrace();
        }
        return devs;
    }

    public Dev getByID(int id){
        Dev dev = new Dev();

        try(Connection conexao = ConnectionBanco.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement("select * from dev where id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultado = preparedStatement.executeQuery();

            if(resultado.next()){
                dev.setId(resultado.getInt("id"));
                dev.setNome(resultado.getString("nome"));
                dev.setProjeto(resultado.getString("projeto"));
                dev.setIdade(resultado.getInt("idade"));
            }

        }catch (SQLException e){
            System.out.println("Erro ao tentar pegar Dev");
            e.printStackTrace();
        }
        return dev;
    }

    public void create(Dev dev){

        try(Connection conexao = ConnectionBanco.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement
                    ("insert into dev (nome, projeto, idade) values (?, ?, ?)");
            preparedStatement.setString(1, dev.getNome());
            preparedStatement.setString(2, dev.getProjeto());
            preparedStatement.setInt(3, dev.getIdade());

            preparedStatement.executeUpdate();
            System.out.println("Dev inserido com Sucesso!");
        }catch (SQLException e){
            System.out.println("Erro ao tentar inserir um dev");
            e.printStackTrace();
        }
    }

    public void update(Dev dev){
        try(Connection conexao = ConnectionBanco.getConnection()){
          PreparedStatement preparedStatement = conexao.prepareStatement
                  ("update dev set nome=?, projeto=?, idade=? where id=?");
          preparedStatement.setString(1, dev.getNome());
          preparedStatement.setString(2, dev.getProjeto());
          preparedStatement.setInt(3, dev.getIdade());
          preparedStatement.setInt(4, dev.getId());

          preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("erro ao tentar atualizar dev "+dev.getNome());
            e.printStackTrace();
        }

    }

    public void delete(int id){
        try(Connection conexao = ConnectionBanco.getConnection()){
            PreparedStatement preparedStatement = conexao.prepareStatement
                    ("delete from dev where id=?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("erro ao tentar deletar dev ");
            e.printStackTrace();
        }

    }
}
