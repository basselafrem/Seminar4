/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.nextgenpos.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 *
 * @author Bassel
 */
public class ErrorMessageHandler {

 /**
 * Displays the specified error message.
 *
 * @param msg The error message.
 */
 void showErrorMsg(String msg) {
     Date date = new Date();
     System.out.println(date + ", Error: " + msg);;
     }


 }