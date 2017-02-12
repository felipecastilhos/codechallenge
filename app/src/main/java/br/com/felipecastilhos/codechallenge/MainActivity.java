package br.com.felipecastilhos.codechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.felipecastilhos.codechallenge.data.dao.UserDAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserDAO userDAO = new UserDAO(this);
    }
}
