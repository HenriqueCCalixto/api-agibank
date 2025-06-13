package com.seguro.api.adapter.datamodel;

import com.seguro.api.domain.enums.TipoSeguro;
import jakarta.persistence.*;

@Entity
@Table(name = "seguros")
public class SeguroDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCliente;

    @Enumerated(EnumType.STRING)
    private TipoSeguro tipoSeguro;

    private boolean contratado;

    public SeguroDataModel() {}

    public SeguroDataModel(Long idCliente, TipoSeguro tipoSeguro, boolean contratado) {
        this.idCliente = idCliente;
        this.tipoSeguro = tipoSeguro;
        this.contratado = contratado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public TipoSeguro getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(TipoSeguro tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public boolean isContratado() {
        return contratado;
    }

    public void setContratado(boolean contratado) {
        this.contratado = contratado;
    }
}
