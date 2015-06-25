package processing.test.sketch_150625a;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_150625a extends PApplet {

public void setup() {
 
  background(0);
}


public void draw() {
  stroke(255);
  strokeWeight(4);
  smooth();
  // Draw if mouse is pressed
  if (mousePressed) {
    line(pmouseX, pmouseY, mouseX, mouseY);
  }


  if (mouseX >= 500 && mouseY >= 300) {
    exit();
  }
}


  public int sketchWidth() { return 300; }
  public int sketchHeight() { return 300; }
}
