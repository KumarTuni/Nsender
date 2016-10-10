package com.rohin.sender;



import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BackActivity extends Activity {
	 Button Sender;
	 String receS, sendS;
	 EditText inputS1;
	 TextView outputS1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.back_activity);
		InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
		Sender = (Button) findViewById(R.id.btn_Sender);
		inputS1 = (EditText) findViewById(R.id.edt_text);
		outputS1= (TextView) findViewById(R.id.txt_output);
		receS = getIntent().getStringExtra("showtext1");
		outputS1.setText(receS);
	    buttonSender();
		
	}
	private void buttonSender() {
		// TODO Auto-generated method stub
		
		Sender.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent inent = new Intent("com.rohin.receiver.AnotherActivity");
				sendS = inputS1.getText().toString();
		        inent.putExtra("showtext", sendS);
		        inent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(inent);
		       
			}
		});

}
}
