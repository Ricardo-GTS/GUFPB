package business.model;

public class Data implements Comparable<Data> {
    private int dia;
    private int mes;
    private int ano;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public int compareTo(Data outraData) {
        if (ano > outraData.getAno()) {
            return -1; // Data atual é maior, retorna -1 para decrescente
        } else if (ano < outraData.getAno()) {
            return 1; // Data atual é menor, retorna 1 para decrescente
        } else {
            // Se os anos são iguais, compara os meses
            if (mes > outraData.getMes()) {
                return -1;
            } else if (mes < outraData.getMes()) {
                return 1;
            } else {
                // Se os meses são iguais, compara os dias
                if (dia > outraData.getDia()) {
                    return -1;
                } else if (dia < outraData.getDia()) {
                    return 1;
                } else {
                    return 0; // As datas são iguais
                }
            }
        }
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
