package com.rohin.sender;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity {



	private static final int REQUEST_PICK_FILE = 1;
	private File selectedFile;




	String fileextension;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button browse=(Button)findViewById(R.id.browse_btn);
		browse.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				Intent intent = new Intent(MainActivity.this, FilePicker.class);
				startActivityForResult(intent, REQUEST_PICK_FILE);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {

			switch (requestCode) {
				case REQUEST_PICK_FILE:
					if (data.hasExtra(FilePicker.EXTRA_FILE_PATH)) {
						selectedFile = new File
								(data.getStringExtra(FilePicker.EXTRA_FILE_PATH));
						fileextension = selectedFile.getAbsolutePath();
						String fileext = fileextension.substring(fileextension.lastIndexOf(".") + 1);

						if (fileext.equalsIgnoreCase("pdf")) {


							Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.adviser121.hanodale");
							launchIntent.putExtra("filepath",selectedFile.getAbsolutePath());
							if (launchIntent != null) {
								startActivity(launchIntent);//null pointer check in case package name was not found
							}


							/*Intent inent = new Intent("com.adviser121.hanodale.PdfActivity");
							inent.putExtra("filepath",selectedFile.getAbsolutePath());
							inent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
							startActivity(inent);*/
							//Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pdf);
						//	inent.putExtra("Bitmap", bitmap);

							/*Intent Pdfintent=new Intent(MainActivity.this,PdfActivity.class);
							Pdfintent.putExtra("filepath",selectedFile.getAbsolutePath());
							startActivity(Pdfintent);*/
						} else {
							Toast.makeText(MainActivity.this, "Plz Select PDF File", Toast.LENGTH_SHORT).show();

						}
					}
					break;
			}
		}
	}




 /* Button Sender;
  EditText inputS;
  TextView outputS;
  String s ;
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
		Sender = (Button) findViewById(R.id.btn_Sender);
		inputS = (EditText) findViewById(R.id.edt_text);
		outputS= (TextView) findViewById(R.id.txt_output);
		
		
		
	    buttonSender();
	}
	private void buttonSender() {
		// TODO Auto-generated method stub
		
		Sender.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View v) {
				Intent inent = new Intent("com.rohin.receiver.AnotherActivity");
				s = inputS.getText().toString();
		        inent.putExtra("showtext", s);
		        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pdf);
		        inent.putExtra("Bitmap", bitmap);
		        inent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		        startActivity(inent);

		       
			}
		});
		
	}*/
}
