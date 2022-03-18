package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date entrada;
    private Date saida;

    public Reserva(Integer numeroQuarto, Date entrada, Date saida) throws DomainException {
        if (!saida.after(entrada)) {
            throw new DomainException("A data de saída deve ser posterior à data de entrada.");
        }
        this.numeroQuarto = numeroQuarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public long duracao(){
        long diferenca = saida.getTime() - entrada.getTime();
        return TimeUnit.DAYS.convert(diferenca,TimeUnit.MILLISECONDS);
    }

    public void atualizarDatas(Date entrada, Date saida) throws DomainException{
        Date agora = new Date();
        if (entrada.before(agora) || saida.before(agora)) {
            throw new DomainException("As datas de reserva para atualização devem ser datas futuras.");
        } if (!saida.after(entrada)) {
            throw new DomainException("A data de saída deve ser posterior à data de entrada.");
        }
        this.entrada = entrada;
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Quarto " + numeroQuarto
                + ", entrada: " + sdf.format(entrada)
                + ", saída: " + sdf.format(saida)
                + ", " + duracao() + " noites";
    }
}