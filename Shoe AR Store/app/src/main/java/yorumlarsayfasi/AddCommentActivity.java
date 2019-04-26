package yorumlarsayfasi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.shoeARstore.MainActivity;
import com.shoeARstore.R;
import com.shoeARstore.getData;

/**
 * Shoe Ar Store
 */

public class AddCommentActivity extends AppCompatActivity {

    private EditText commentText;
    private RatingBar commentRating;
    private TextView saveComment;
    private String kullaniciid,stockcode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_comment);

        SharedPreferences prefs =getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        kullaniciid=prefs.getString("id","0");

        if(getIntent().getExtras()!=null){
            stockcode=getIntent().getExtras().getString("stockcode");
        }

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        TextView title=(TextView) toolbar.findViewById(R.id.eshop);
        title.setText("YORUM GÖNDER");
        ImageView backButton=(ImageView) toolbar.findViewById(R.id.backImage);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Tanımlamalar
        commentText=(EditText) findViewById(R.id.comment);
        commentRating=(RatingBar) findViewById(R.id.commentRating);
        saveComment=(TextView) findViewById(R.id.saveComment);

        saveComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!commentText.getText().toString().equals("") && commentRating.getRating()!=0){
                    new getData(AddCommentActivity.this){
                        @Override
                        protected void onPostExecute(String s) {
                            if(!s.equals("Hata")){
                                Toast.makeText(AddCommentActivity.this, "Yorumunuz Gönderildi...", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(AddCommentActivity.this, "Yorumunuz Gönderilemedi!!!", Toast.LENGTH_SHORT).show();
                            }
                            dialog.dismiss();
                            super.onPostExecute(s);
                        }
                    }.execute(MainActivity.server_url+"addcomment.php",kullaniciid+"-"+commentText.getText().toString(),String.valueOf(commentRating.getRating())+"-"+stockcode);
                }else{
                    Toast.makeText(AddCommentActivity.this, "Lütfen Bilgileri Eksiksiz Doldurun!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
