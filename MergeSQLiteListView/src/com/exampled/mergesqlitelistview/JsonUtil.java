package com.exampled.mergesqlitelistview;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.projecttestsqlite.Subject;

public class JsonUtil {

	public static String toJSon(Subject sub)
	{
	     try {
	        // Here we convert Java Object to JSON 
	        JSONObject jsonObj = new JSONObject();
	        jsonObj.put("pseudo", sub.getPseudo()); // Set the first name/pair 
	        jsonObj.put("title", sub.getTitle());
	        jsonObj.put("category", sub.getTags());
	        jsonObj.put("content", sub.getContent());
	        jsonObj.put("id", sub.getID());

	        return jsonObj.toString();
	     
	     } catch(JSONException ex) {
	    	 ex.printStackTrace();
		 }	
	     return null;
	}
	
}
