package br.uffs.cc.jarena;

public class Patodonald extends Agente
{

	int[] Objetivo = {0,0};
	int id = this.getId()%15;
	Boolean stop = false;
	int contador = 0;
	int energiaTeste = 0;

	public Patodonald(Integer x, Integer y, Integer energia) {
		super(x, y, energia);
		setDirecao(this.NENHUMA_DIRECAO);
		this.Objetivo = SelecionaObjetivo(this.id);
	}

	public void pensa() {
		if (getEnergia() < this.energiaTeste){
			this.stop = false;
			this.energiaTeste = 0;
		}
		else if (this.stop) {
			setDirecao(this.NENHUMA_DIRECAO);
		}
		else if (this.stop == false) {
			irObjetivo(this.Objetivo);
		}
	}


	public void irObjetivo(int[] Objetivo){
		if ((Objetivo[0] == this.getX()) && (Objetivo[1] == this.getY())){
			// this.stop = true;
			this.contador += 2;
			this.Objetivo = SelecionaObjetivo(this.id);
			if (this.contador > 7){
				this.contador = 0;
			}

		}
		else if (Objetivo[0] > this.getX()){
			setDirecao(this.DIREITA);
		}
		else if (Objetivo[1] > this.getY()){
			setDirecao(this.BAIXO);
		}
		else if (Objetivo[0] < this.getX()){
			setDirecao(this.ESQUERDA);
		}
		else if (Objetivo[1] < this.getY()){
			setDirecao(this.CIMA);
		}
	}

	public int[] SelecionaObjetivo(int id){
		int[] Objetivo = {0,0};

		switch (id){
			case 0:
				int[] lista0 = {855,660,0,660,0,0,855,660,0,660,0,0};
				Objetivo[0] = lista0[this.contador];
				Objetivo[1] = lista0[this.contador+1];
				break;
			case 1:
				int[] lista1 = {0,0,0,660,855,660,855,0,0,0,660,855,660};
				Objetivo[0] = lista1[this.contador];
				Objetivo[1] = lista1[this.contador+1];
				break;
			case 2:
				int[] lista2 = {805,50,805,610,50,610,50,50,805,50,805,610,50,610,50,50};
				Objetivo[0] = lista2[this.contador];
				Objetivo[1] = lista2[this.contador+1];
				break;
			case 3:
				int[] lista3 = {805,50,50,50,50,610,805,610,805,50,50,50,50,610,805,610};
				Objetivo[0] = lista3[this.contador];
				Objetivo[1] = lista3[this.contador+1];
				break;
			case 4:
				int[] lista4 = {755,100,755,560,100,560,100,100,755,100,755,560,100,560,100,100};
				Objetivo[0] = lista4[this.contador];
				Objetivo[1] = lista4[this.contador+1];
				break;
			case 5:
				int[] lista5 = {755,100,100,100,100,560,755,560,755,100,100,100,100,560,755,560};
				Objetivo[0] = lista5[this.contador];
				Objetivo[1] = lista5[this.contador+1];
				break;
			case 6:
				int[] lista6 = {705,150,705,510,150,510,150,150,705,150,705,510,150,510,150,150};
				Objetivo[0] = lista6[this.contador];
				Objetivo[1] = lista6[this.contador+1];
				break;
			case 7:
				int[] lista7 = {705,150,150,150,150,510,705,510,705,150,150,150,150,510,705,510};
				Objetivo[0] = lista7[this.contador];
				Objetivo[1] = lista7[this.contador+1];
				break;
			case 8:
				int[] lista8 = {655,200,655,460,200,460,200,200,655,200,655,460,200,460,200,200};
				Objetivo[0] = lista8[this.contador];
				Objetivo[1] = lista8[this.contador+1];
				break;
			case 9:
				int[] lista9 = {655,200,200,200,200,460,655,460,655,200,200,200,200,460,655,460};
				Objetivo[0] = lista9[this.contador];
				Objetivo[1] = lista9[this.contador+1];
				break;
			case 10:
				int[] lista10 = {605,250,605,410,250,410,250,250,605,250,605,410,250,410,250,250};
				Objetivo[0] = lista10[this.contador];
				Objetivo[1] = lista10[this.contador+1];
				break;
			case 11:
				int[] lista11 = {605,250,250,250,250,410,605,410,605,250,250,250,250,410,605,410};
				Objetivo[0] = lista11[this.contador];
				Objetivo[1] = lista11[this.contador+1];
				break;
			case 12:
				int[] lista12 = {555,300,555,360,300,360,300,300,555,300,555,360,300,360,300,300};
				Objetivo[0] = lista12[this.contador];
				Objetivo[1] = lista12[this.contador+1];
				break;
			case 13:
				int[] lista13 = {555,300,300,300,300,360,555,360,555,300,300,300,300,360,555,360};
				Objetivo[0] = lista13[this.contador];
				Objetivo[1] = lista13[this.contador+1];
				break;
			case 14:
				int[] lista14 = {805,50,755,100,705,150,655,200,605,250,555,300,505,350,455,400,405,450,355,500,805,50};
				Objetivo[0] = lista14[this.contador];
				Objetivo[1] = lista14[this.contador+1];
				break;
		}
		return Objetivo;
	}


	public void recebeuEnergia() {
		this.energiaTeste = getEnergia();
		this.stop = true;
		String msg = this.getX() + " " + this.getY();
		enviaMensagem(msg);
	}

	public void recebeuMensagem(String msg) {
		String array[] = new String[2];
		array = msg.split(" ");
		int X = Integer.parseInt(array[0]);
		int Y = Integer.parseInt(array[1]);
		this.Objetivo[0] = X;
		this.Objetivo[1] = Y;
	}


	public void tomouDano(int energiaRestanteInimigo) {
	}
	public void ganhouCombate() {
	}

	public String getEquipe() {
		return "time Time";
	}
}
