package com.greenbirdtech.blockchain.cordapp.webdiamond.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;

import net.corda.core.contracts.Amount;

public class StringUtil 
{
	public static final char NEWLINE='\n';
	public static final char SPACECHAR=' ';
	public static final char FIELDNAMESEP='_';
	public static final char METERINDICATOR='\n';
	public static final char COLONCHAR=':';
	public static final char COMMACHAR=',';
	public static final char TABCHAR='\t';
	public static final char PIPECHAR='|';
	public static final char DOTCHAR='.';
	public static final char COMMENTCHAR='#';
	public static final String COMMASTR=",";
	public static final String SPACESTR=" ";
	public static final String FIELDNAMESEPSTR="_";
	public static final String TABSTR="\t";
	public static final String PIPESTR="\\|";
	public static final String EMPTY_STRING="";
	public static final String NULL_STRING="null";
	public static final String COLONSTR=":";
	public static final String LFCRSTR="\r\n";
	public static final String UNKNOWNSTR="--";
	public static final String UTF8STR="UTF-8";
	public static final String LOCALHOSTSTR="localhost";
	public static final char[] HEXCHAR={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	
	public static boolean isNull(final String str)
	{
		if ((str == null) || (str.equalsIgnoreCase(NULL_STRING)) || str.trim().equals(EMPTY_STRING))
			return(true);
		return(false);
	}
	
	public static String formTxnprice(Amount<Currency> amount)
	{
		return((amount == null) ? null : String.format("%1$s %2$d",amount.getToken().getCurrencyCode(),amount.getQuantity()));
	}
	
	public static Timestamp extractDateinfo(String data,SimpleDateFormat dataDF)
	{
		Timestamp tsTemp=null;
		if (!StringUtil.isNull(data))
		{
			try
			{
				tsTemp = new Timestamp(dataDF.parse(data).getTime());
			}
			catch (ParseException pe)
			{
			}
		}
		return(tsTemp);
	}
}
