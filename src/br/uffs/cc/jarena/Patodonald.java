package br.uffs.cc.jarena;

public class Patodonald extends Agente
{

	int[] Objetivo = {0,0};
	int id = this.getId()%15;
	Boolean chegou = false;

	public Patodonald(Integer x, Integer y, Integer energia) {
		super(x, y, energia);
		setDirecao(this.NENHUMA_DIRECAO);
		this.Objetivo = SelecionaObjetivo(this.id);
	}

	public void pensa() {
		if(chegou == false){
			irObjetivo(this.Objetivo);
		}
		if (this.chegou){
			setDirecao(this.NENHUMA_DIRECAO);
			return;
		}
	}


	public void irObjetivo(int[] Objetivo){
		if ((Objetivo[0] == this.getX()) && (Objetivo[1] == this.getY())){
			chegou = true;
			setDirecao(this.NENHUMA_DIRECAO);
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
				Objetivo[0] = 855;
				Objetivo[1] = 600;
				break;
			case 1:
				Objetivo[0] = 300;
				Objetivo[1] = 300;
				break;
			case 2:
				Objetivo[0] = 455;
				Objetivo[1] = 235;
				break;
			case 3:
				Objetivo[0] = 0;
				Objetivo[1] = 0;
				break;
			case 4:
				Objetivo[0] = 257;
				Objetivo[1] = 760;
				break;
			case 5:
				Objetivo[0] = 500;
				Objetivo[1] = 150;
				break;
			case 6:
				Objetivo[0] = 105;
				Objetivo[1] = 440;
				break;
			case 7:
				Objetivo[0] = 570;
				Objetivo[1] = 0;
				break;
			case 8:
				Objetivo[0] = 710;
				Objetivo[1] = 620;
				break;
			case 9:
				Objetivo[0] = 630;
				Objetivo[1] = 200;
				break;
			case 10:
				Objetivo[0] = 800;
				Objetivo[1] = 430;
				break;
			case 11:
				Objetivo[0] = 430;
				Objetivo[1] = 430;
				break;
			case 12:
				Objetivo[0] = 150;
				Objetivo[1] = 300;
				break;
			case 13:
				Objetivo[0] = 475;
				Objetivo[1] = 375;
				break;
			case 14:
				Objetivo[0] = 700;
				Objetivo[1] = 200;
				break;
			// default:
			// 	setDirecao(this.NENHUMA_DIRECAO);
				// break;
		}
		return Objetivo;
	}



	public void recebeuEnergia() {
		this.setDirecao(this.NENHUMA_DIRECAO);
		this.chegou = true;
		String msg = this.getX() + " " + this.getY();
		enviaMensagem(msg);
		// Invocado sempre que o agente recebe energia.
	}

	public void tomouDano(int energiaRestanteInimigo) {
	}

	public void ganhouCombate() {
	}

	public void recebeuMensagem(String msg) {
		chegou = false;
		String array[] = new String[2];
		array = msg.split(" ");
		int X = Integer.parseInt(array[0]);
		int Y = Integer.parseInt(array[1]);
		this.Objetivo[0] = X;
		this.Objetivo[1] = Y;
		this.irObjetivo(this.Objetivo);
	}

	public String getEquipe() {
		return "time Time";
	}
}
