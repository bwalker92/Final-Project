package com.mkyong.android;

import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
 


public class App2Activity extends Activity {
		
		
		Button button1;
		

		
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main2);
			
			setCurrentTimeOnView();
			addListenerOnButton();
		}
		
				//Time
private TextView tvDisplayDate;
private DatePicker dpResult;
private Button btnChangeDate;
				//Date 
private TextView tvDisplayTime;
private TimePicker timePicker1;
private Button btnChangeTime;

private int hour;
private int minute;

private int year;
private int month;
private int day;
			 

static final int DATE_DIALOG_ID = 999;
static final int TIME_DIALOG_ID = 999;

final Activity App2Activity = this;
				

// display current time
public void setCurrentTimeOnView() {
	
	tvDisplayTime = (TextView) findViewById(R.id.tvTime);
	timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
	
	final Calendar c = Calendar.getInstance();
	hour = c.get(Calendar.HOUR_OF_DAY);
	minute = c.get(Calendar.MINUTE);
}

// display current date
public void setCurrentDateOnView() {
	
	tvDisplayDate = (TextView) findViewById(R.id.tvDate);
	dpResult = (DatePicker) findViewById(R.id.dpResult);
	
	final Calendar c = Calendar.getInstance();
	year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		
		
		
		
			// set current date into textview
		tvDisplayDate.setText(new StringBuilder()
		// Month is 0 based, just add 1
		.append(month + 1).append("-").append(day).append("-")
		.append(year).append(" "));
		
		// set current date into datepicker
		dpResult.init(year, month, day, null);
		
		
		
		
		
		
		// set current time into textview
		tvDisplayTime.setText(new StringBuilder().append(pad(hour)).append(":")
				.append(pad(minute)));
		
		// set current time into timepicker
		timePicker1.setCurrentHour(hour);
		timePicker1.setCurrentMinute(minute);
		
		
		
		final Button button = (Button) findViewById(R.id.addNew);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(App2Activity, "Appointment Has Been Added ", Toast.LENGTH_SHORT).show();
			}
		});
}	
	
public void addListenerOnButton() {
	
	btnChangeTime = (Button) findViewById(R.id.btnChangeTime);
	
	btnChangeTime.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			showDialog(TIME_DIALOG_ID);
			
		}
		
	});
	
}

public void addListenerOnButton1() {
	
	btnChangeDate = (Button) findViewById(R.id.btnChangeDate);
	
	btnChangeDate.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			showDialog(DATE_DIALOG_ID);
			
		}
		
	});
	
}


@Override
protected Dialog onCreateDialog(int id) {
	switch (id) {
	case DATE_DIALOG_ID:
		// set date picker as current date
		return new DatePickerDialog(this, datePickerListener, 
				year, month,day);
	}
	return null;
}

private DatePickerDialog.OnDateSetListener datePickerListener 
= new DatePickerDialog.OnDateSetListener() {
		
	// when dialog box is closed, below method will be called.
	public void onDateSet(DatePicker view, int selectedYear,
			int selectedMonth, int selectedDay) {
		year = selectedYear;
		month = selectedMonth;
		day = selectedDay;
		
		// set selected date into textview
		tvDisplayDate.setText(new StringBuilder().append(month + 1)
				.append("-").append(day).append("-").append(year)
				.append(" "));
			 	
		// set selected date into datepicker also
		dpResult.init(year, month, day, null);
		
	}
};


	
		
protected Dialog onCreateDialog1(int id) {
	switch (id) {
	case TIME_DIALOG_ID:
		// set time picker as current time
		return new TimePickerDialog(this, timePickerListener, hour, minute,
				false);
		
	}
					return null;
}
	
private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
	public void onTimeSet(TimePicker view, int selectedHour,
			int selectedMinute) {
		hour = selectedHour;
		minute = selectedMinute;
		
		// set current time into textview
		tvDisplayTime.setText(new StringBuilder().append(pad(hour))
				.append(":").append(pad(minute)));
			
		// set current time into timepicker
		timePicker1.setCurrentHour(hour);
		timePicker1.setCurrentMinute(minute);
		
	}
};
	
private static String pad(int c) {
	if (c >= 10)
		return String.valueOf(c);
	else
		return "0" + String.valueOf(c);
}


	
	
		
		}

	



	
			