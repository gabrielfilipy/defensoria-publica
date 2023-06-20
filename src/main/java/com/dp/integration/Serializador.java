package com.dp.integration;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;

import com.dp.enums.Rotulos;
import com.dp.model.Insumo;
import com.google.gson.Gson;

@Configuration
public class Serializador {
	String regiao;
	public static List<Insumo> jsonParaColecaoObjetoJavaJson(String json) {	
		JSONObject obj = null;
		List<Insumo> insumos = null;
		Insumo insumo = null;
		Gson gson = null;
		
		try {
			
			obj = new JSONObject(json);
			insumos = new ArrayList<>();
			JSONArray list = obj.getJSONArray("results");
			for(int i = 0; i < list.length(); i++) {
				insumo = new Insumo();
				gson = new Gson();
				JSONObject o = list.getJSONObject(i);
				
				insumo = gson.fromJson(o.toString(), Insumo.class);
				 
				if(insumo.getGender().equals("female"))
					insumo.setGender("F");
				
				if(insumo.getGender().equals("male"))
					insumo.setGender("M");
				
				//Para exemplificar a filtragem adicionei alguns usuário para terem regiões diferentes.
				if(insumo.getLocation().getPostcode() == 89591)
					insumo.getLocation().setRegion("SUL"); 
				
				if(insumo.getLocation().getPostcode() == 25627)
					insumo.getLocation().setRegion("NORDESTE"); 
				
				if(insumo.getLocation().getRegion() == null)
					insumo.getLocation().setRegion("CENTRO_OESTE");
				 
				if((insumo.getLocation().getCoordinates().getLatitude().equals(Rotulos.ESPECIAL.getMinlat001())
						&& insumo.getLocation().getCoordinates().getLongitude().equals(Rotulos.ESPECIAL.getMinlon001()))
					|| (insumo.getLocation().getCoordinates().getLatitude().equals(Rotulos.ESPECIAL.getMinlat002())
							&& insumo.getLocation().getCoordinates().getLongitude().equals(Rotulos.ESPECIAL.getMinlon002()))
					|| (insumo.getLocation().getCoordinates().getLatitude().equals(Rotulos.ESPECIAL.getMaxlat001())
							&& insumo.getLocation().getCoordinates().getLongitude().equals(Rotulos.ESPECIAL.getMaxlon001()))
					|| (insumo.getLocation().getCoordinates().getLatitude().equals(Rotulos.ESPECIAL.getMaxlat002())
							&& insumo.getLocation().getCoordinates().getLongitude().equals(Rotulos.ESPECIAL.getMaxlon002()))) {
					insumo.setType("ESPECIAL");
				} else if((insumo.getLocation().getCoordinates().getLatitude().equals(Rotulos.NORMAL.getMinlat001())
						&& insumo.getLocation().getCoordinates().getLongitude().equals(Rotulos.NORMAL.getMinlon001()))
					|| (insumo.getLocation().getCoordinates().getLatitude().equals(Rotulos.NORMAL.getMaxlat002())
							&& insumo.getLocation().getCoordinates().getLongitude().equals(Rotulos.NORMAL.getMaxlon002()))) {
					insumo.setType("NORMAL");
				} else {
					insumo.setType("TRABALHOSO");
				}
				
				insumos.add(insumo);
                
            }
			 
		} catch (Exception e) { 
			System.out.println("Error: " + e.getMessage());
		}
		
		return insumos;
		
	}

}
