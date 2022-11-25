package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UsuarioDAOTest {


    @Test
    public void inicializar() {
        IDAO usuarioDao = new UsuarioDAO();
        Usuario u1 = new Usuario("Mateus Altair", "maltair", "123456");
        Usuario u2 = new Usuario("Paloma", "paloma", "18101979");
        Usuario u3 = new Usuario("Fabricio Gurguri", "gurguri", "000000");
        Usuario u4 = new Usuario("Marcones Sousa", "marc", "121212");
        usuarioDao.salvar(u1);
        usuarioDao.salvar(u2);
        usuarioDao.salvar(u3);
        usuarioDao.salvar(u4);
    }

    @Test
    public void insert() {
        IDAO usuarioDao = new UsuarioDAO();
        Usuario usuario = new Usuario("Hyago Hamon", "hyago", "123");
        boolean validacao = usuarioDao.salvar(usuario);
        Assert.assertTrue(validacao);
    }


    @Test
    public void update() {
        IDAO usuarioDao = new UsuarioDAO();
        Usuario usuarioDb = (Usuario) usuarioDao.obter(3L);
        usuarioDb.setNome("Pedro Henrique");
        usuarioDb.setUsuario("Pedro");
        usuarioDb.setSenha("123456");
        boolean validacao = usuarioDao.atualizar(usuarioDb);
        Assert.assertTrue(validacao);

    }

    @Test
    public void delete() {
        IDAO usuarioDao = new UsuarioDAO();
        Usuario usuarioDb = (Usuario) usuarioDao.obter(4L);
        System.out.println(usuarioDb);
        boolean validacao = usuarioDao.deletar(usuarioDb);
        Assert.assertTrue(validacao);

    }


    @Test
    public void listaTodos() {
        IDAO usuarioDao = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDao.listarTodos();
        Assert.assertNotNull(usuarios);


    }


    @Test
    public void listaPorCodigo() {
        IDAO usuarioDao = new UsuarioDAO();
        Usuario usuario = (Usuario) usuarioDao.obter(2l);
        Assert.assertNotNull(usuario);
    }
}