package com.example.rss;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.util.ByteArrayBuffer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/*
 * Tache asynchrone, qui telecharge un ficier RSS, le parse et le stock en base de donnees
 */
public class AddChannel extends AsyncTask<String, Integer, Long> {
	ProgressDialog progressDialog;
	Context mContext;
	int max = 0;
	
	public AddChannel(Context mContext){
		this.mContext = mContext;
	}
	
	@Override
	protected Long doInBackground(String... urls) {
		if(urls == null){
			return 0L;
		}
		String sTitle;
        String sLink;
        String sDescription;
        String sPubDate;
        String sImageUrl;
        Date date = new Date();
        byte[] image = null;
        int length = urls.length;

        try {
        	boolean plusRecent;
        	for(int i=0; i<length; i++){
        		plusRecent = true;
	        	String sUrl = urls[i];;
	        	URL url = new URL(sUrl);
	        	URLConnection connection;
	        	connection = url.openConnection();
	        	HttpURLConnection httpConnection = (HttpURLConnection)connection;
	        	int responseCode = httpConnection.getResponseCode();
	        	if (responseCode == HttpURLConnection.HTTP_OK) {
	        		InputStream in = httpConnection.getInputStream();
				
				
			        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder db = dbf.newDocumentBuilder();
					Document doc = db.parse (in);
					doc.getDocumentElement ().normalize ();
	
			        NodeList channel = doc.getElementsByTagName("channel");
			        Node noeud2 = channel.item(0);
		        	Element channelElement = (Element)noeud2;
		        	
		        	
		        	NodeList nodeList, nodeList2;
		        	Element element;
		        	
		        	nodeList = channelElement.getElementsByTagName("title");
		        	if(nodeList.getLength() != 0){
			            element = (Element)nodeList.item(0);
			            nodeList2 = element.getChildNodes();
			            sTitle = ((Node)nodeList2.item(0)).getNodeValue().trim();
		        	}
		        	else{
		        		sTitle = "";
		        	}
		
		            nodeList = channelElement.getElementsByTagName("description");	    
		            if(nodeList.getLength() != 0){
			            element = (Element)nodeList.item(0);
			            nodeList2 = element.getChildNodes();
		                if(nodeList2.item(0) == null){
		                	sDescription = "";
		                }
		                else{
		                	sDescription = ((Node)nodeList2.item(0)).getNodeValue().trim();
		                }
		            }
		            else{
		            	sDescription = "";
		            }
		            
		            nodeList = channelElement.getElementsByTagName("pubDate");	        	
		            element = (Element)nodeList.item(0);
		            nodeList2 = element.getChildNodes();
		            sPubDate = ((Node)nodeList2.item(0)).getNodeValue().trim();
		            
		            nodeList = channelElement.getElementsByTagName("link");	
		            if(nodeList.getLength() != 0){
			            element = (Element)nodeList.item(0);
			            nodeList2 = element.getChildNodes();
			            sLink = ((Node)nodeList2.item(0)).getNodeValue().trim();
		            }
		            else{
		            	sLink = "";
		            }
		            
		            nodeList = channelElement.getElementsByTagName("image");	        	
		            if(nodeList.getLength() != 0){
		            	Node noeud = nodeList.item(0);
			        	Element noeudElement = (Element)noeud;
			        	
			        	nodeList = noeudElement.getElementsByTagName("url");	        	
		                element = (Element)nodeList.item(0);
		                nodeList2 = element.getChildNodes();
		                sImageUrl = ((Node)nodeList2.item(0)).getNodeValue().trim();
		                
		                image = getLogoImage(sImageUrl);
		            }
	
			        NodeList items = doc.getElementsByTagName("item");
			        
			        DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
			        try {
						date = formatter.parse(sPubDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
			        
			        String channelId = sUrl;
			        DB.insertChannel(sUrl, sTitle, sDescription, date.getTime(), sLink, image);
			        
			        // Recupere la date de la derniere news
			        long maxDate = DB.getMaxDate(channelId);
			        
			        int length2 = items.getLength();
			        publishProgress(1, length2);
			        
			        for(int j=0; j<length2; j++){
			        	if(plusRecent){
				        	Node noeud = items.item(j);
				        	Element noeudElement = (Element)noeud;
				        	
				        	nodeList = noeudElement.getElementsByTagName("title");	   
				        	if(nodeList.getLength() != 0){
				                element = (Element)nodeList.item(0);
				                nodeList2 = element.getChildNodes();
				                sTitle = ((Node)nodeList2.item(0)).getNodeValue().trim();
				        	}
				        	else{
				        		sTitle = "";
				        	}
			                
			                nodeList = noeudElement.getElementsByTagName("link");	  
			                if(nodeList.getLength() != 0){
				                element = (Element)nodeList.item(0);
				                nodeList2 = element.getChildNodes();
				                sLink = ((Node)nodeList2.item(0)).getNodeValue().trim();
			                }
			                else{
			                	sLink ="";
			                }
			                
			                nodeList = noeudElement.getElementsByTagName("description");
			                if(nodeList.getLength() != 0){
			                	element = (Element)nodeList.item(0);
			                
				                nodeList2 = element.getChildNodes();
				                if(nodeList2.item(0) == null){
				                	sDescription = "";
				                }
				                else{
				                	sDescription = ((Node)nodeList2.item(0)).getNodeValue().trim();
				                }
			                }
			                else{
			                	sDescription = "";
			                }
	
			                nodeList = noeudElement.getElementsByTagName("pubDate");	
			                element = (Element)nodeList.item(0);
			                nodeList2 = element.getChildNodes();
			                sPubDate = ((Node)nodeList2.item(0)).getNodeValue().trim();
	 
			                try {
								date = formatter.parse(sPubDate);
							} catch (ParseException e) {
								e.printStackTrace();
							}
			                
			                // Test si l'item en train d'etre parse est plus recent
			                long iDate = date.getTime();
			                Log.e("date", "maxDate : "+maxDate+", iDate : "+iDate);
			                if(iDate <= maxDate){
			                	plusRecent = false;
			                }
			                else{
				                DB.insertItem(channelId, sTitle, sDescription, date.getTime(), sLink);
				                publishProgress(0,j+1);
			                }
			        	}
			        }
			        publishProgress(4);
		        }
        	}

		} catch (IOException e1) {
			publishProgress(3);
			e1.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
        
		return null;
    }

	@Override
    protected void onProgressUpdate(Integer... progress) {
		
    	switch(progress[0]){
    		case 0 :
    			progressDialog.setMessage(progress[1]+"/"+max);
    			break;
    		case 1 :
    			max = progress[1];
    			break;
    		case 3 :
    			Toast.makeText(mContext, mContext.getString(R.string.connection_problem), Toast.LENGTH_SHORT).show();
    			break;
    		case 4 :
    			Toast.makeText(mContext, mContext.getString(R.string.success), Toast.LENGTH_SHORT).show();
    		default :
    			break;
    	}
    }

    @Override
    protected void onPostExecute(Long result) {
    	// Ferme le dialogue de progres
    	progressDialog.dismiss();
    	// Actualise l'affichage
    	if(mContext instanceof ItemActivity){
    		((ItemActivity)mContext).onResume();
    	}
    	else if(mContext instanceof MainActivity){
    		((MainActivity)mContext).onResume();
    	}
    }
    
    @Override
    protected void onPreExecute(){
    	// Affiche le dialogue de progres
    	progressDialog = ProgressDialog.show(mContext, mContext.getString(R.string.download), mContext.getString(R.string.wait));     	 
    }

	private byte[] getLogoImage(String url){
	     try {
	             URL imageUrl = new URL(url);
	             URLConnection ucon = imageUrl.openConnection();

	             InputStream is = ucon.getInputStream();
	             BufferedInputStream bis = new BufferedInputStream(is);

	             ByteArrayBuffer baf = new ByteArrayBuffer(500);
	             int current = 0;
	             while ((current = bis.read()) != -1) {
	                     baf.append((byte) current);
	             }

	             return baf.toByteArray();
	     } catch (Exception e) {
	             Log.d("ImageManager", "Error: " + e.toString());
	     }
	     return null;
	}
}
