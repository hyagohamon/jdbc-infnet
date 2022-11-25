package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends JdbcDAO<Usuario> {
    @Override
    public Boolean salvar(Usuario usuario) {
        String sql = "insert into usuario(nome,usuario,senha) values (?,?,?)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getUsuario());
            pstm.setString(3, usuario.getSenha());
            return pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean atualizar(Usuario usuario) {
        String sql = "update usuario set nome =?, usuario=?,senha=? where codigo =? ";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getUsuario());
            pstm.setString(3, usuario.getSenha());
            pstm.setLong(4, usuario.getCod());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletar(Usuario usuario) {
        String sql = "delete usuario from usuario where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, usuario.getCod());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Usuario obter(Long codigo) {
        String sql = "select * from usuario where codigo = ?";
        Usuario usuario = new Usuario();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, codigo);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Long codigoDB = rs.getLong("codigo");
                String nome = rs.getString("nome");
                String usuario1 = rs.getString("usuario");
                String senha = rs.getString("senha");
                usuario = new Usuario(codigoDB, nome, usuario1, senha);
            }
            return usuario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        String sql = "select * from usuario";
        try {
            pstm = con.prepareStatement(sql);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()) {
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCod(rs.getLong("codigo"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
