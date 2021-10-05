package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.IngredienteVO;
import model.MontaditoDAO;
import model.MontaditoVO;

public class LanzadorPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MontaditoDAO montaditoDAO = new MontaditoDAO();
		MontaditoVO montadito = new MontaditoVO();

//Test de getMontadito
		System.out.println("Cargamos el montadito 1");
		montadito = montaditoDAO.getMontaditoDB(3);

		System.out.println(montadito.getNombre() + " tiene un precio de " + montadito.getPrecio());

		// Test de

		ArrayList<MontaditoVO> listaMontadito = montaditoDAO.cargarMontaditosBD();

		// Recorro la lista mostrando el nombre y el precio de
		// Todos los montaditos
		for (int i = 0; i < listaMontadito.size(); i++) {
			System.out.println("Montadito " + i + " Nombre:" + listaMontadito.get(i).getNombre()
					+ " tiene un precio de " + listaMontadito.get(i).getPrecio());
		}

		ArrayList<IngredienteVO> listaIngredientes = montaditoDAO.cargarIngredientes(3);

		// Recorro la lista mostrando el nombre de los ingredientes
		Iterator<IngredienteVO> itr = listaIngredientes.iterator();
		int i = 1;

		while (itr.hasNext()) {

			IngredienteVO ingrediente = itr.next();
			System.out.println(
					"Ingrediente " + i + " Nombre:" + ingrediente.getNombre() + " Tipo " + ingrediente.getTipo());
			i++;

		}

	}

}
