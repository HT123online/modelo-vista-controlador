public class control_registrar_invitado {
    private diseno capa_diseno;

    public control_registrar_invitado(diseno capa_diseno){
        this.capa_diseno=capa_diseno;
        combos();
    }

    private void combos(){
        //capa_diseno.combo_año.addItem(2);
        var combo_mes=capa_diseno.combo_mes;
        var combo_dia=capa_diseno.combo_dia;
        var combo_año=capa_diseno.combo_año;
        for(int i=1; i<=31; i++) combo_dia.addItem(""+i);
        String[] meses = {"ene","feb","mar","abr","may","jun","jul","ago","sep","oct","nov","dic"};
        for(String m : meses) combo_mes.addItem(m);
        for(int i=2000; i<=2026; i++) combo_año.addItem(""+i);

    }
}
