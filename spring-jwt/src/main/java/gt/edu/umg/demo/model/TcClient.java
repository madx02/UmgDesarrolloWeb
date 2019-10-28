package gt.edu.umg.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TcClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;

    @NotNull
    private String fullname;


    public TcClient() {
    }

    public TcClient(int clientId, String fullname) {
        this.clientId = clientId;
        this.fullname = fullname;
    }

    public int getClientId() {
        return this.clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public TcClient clientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public TcClient fullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

}