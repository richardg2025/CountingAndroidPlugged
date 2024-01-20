package sortingandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.sortingandroid.R;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static boolean doesFileExist;
    TextView result;
    EditText inputText;
    String fileName;
    Button top, top5;
    @SuppressLint("StaticFieldLeak")
    public static Context tContext;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tContext = MainActivity.this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);

        result = findViewById(R.id.result);
        top = findViewById(R.id.top);
        top5 = findViewById(R.id.top5);

        top.setOnClickListener(v -> {
            fileName = String.valueOf(inputText.getText());
            Counter counter = new Counter("commonWords.txt", fileName + ".txt");

            if (doesFileExist) {
                String[] top5Words = counter.getTopFiveWords();
                int[] top5Freq = counter.getTopFiveFrequencies();

                String results = "The most common word in " + "\n" + fileName + " is " + "\"" + top5Words[0] + "\"" + " with " + "\n" + top5Freq[0] + " occurences.";
                result.setText(results);
            } else result.setText("No file found!");
        });

        top5.setOnClickListener(v -> {
            fileName = String.valueOf(inputText.getText());
            Counter counter = new Counter("commonWords.txt", fileName + ".txt");

            if (doesFileExist) {
                String[] top5Words = counter.getTopFiveWords();
                int[] top5Freq = counter.getTopFiveFrequencies();

                String results = "The top 5 most common words" + "\n" + "in " + fileName + " are:" + "\n" + "\"" + top5Words[0] + "\"" + " with " + top5Freq[0] + " occurences" + "\n" + "\"" + top5Words[1] + "\"" + " with " + top5Freq[1] + " occurences" + "\n" + "\"" + top5Words[2] + "\"" + " with " + top5Freq[2] + " occurences" + "\n" + "\"" + top5Words[3] + "\"" + " with " + top5Freq[3] + " occurences" + "\n" + "\"" + top5Words[4] + "\"" + " with " + top5Freq[4] + " occurences";
                result.setText(results);
            } else result.setText("No file found!");
        });
    }
}
