package com.examplet.organisedtest;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        
    setContentView(R.layout.activity_main);
        
    Resources res = getResources();
    String chaine = res.getString(R.string.hello, "Anas", 22);
    TextView vue = (TextView)findViewById(R.id.vue);
    vue.setText(chaine);
    
    Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);

    vue.startAnimation(animation);
  }
}
