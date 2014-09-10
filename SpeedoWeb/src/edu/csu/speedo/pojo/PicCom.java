package edu.csu.speedo.pojo;

import java.util.ArrayList;

import edu.csu.speedo.dto.PictureDto;

public class PicCom {
private int score;
private PictureDto pic;
public void setScore(int score){this.score=score;}
public int getScore(){
	return score;
}
public void setPic(PictureDto pic){
	this.pic=pic;
	
}

public PictureDto  getPic(){
	return pic;
}


}
