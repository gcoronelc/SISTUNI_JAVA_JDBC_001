package uni.sistemas.controller;

import java.util.List;
import uni.sistemas.entity.ClienteTO;
import uni.sistemas.model.ClienteDAO;

public class ClienteBLL {

    ClienteDAO dao;

    public ClienteBLL() {
        dao = new ClienteDAO();
    }

    public List<ClienteTO> ClienteListar() throws Exception {
        return dao.readAll();
    }

}
