package tatastrive.application.party;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    SoundPool sp;
    MediaPlayer mm;
    int explosion = 0;
    Random crazy = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // setContentView( R.layout.activity_main );
        View view = new View( this );
        view.setOnClickListener( this );
        view.setOnLongClickListener( this );
        setContentView( view );

        sp = new SoundPool( 5, AudioManager.STREAM_MUSIC, 0 );
        explosion = sp.load( this, R.raw.soundtrack, 1 );
        mm = MediaPlayer.create( this, R.raw.backgroundmusic );
        view.setBackgroundColor( Color.rgb( crazy.nextInt( 256 ), crazy.nextInt( 256 ), crazy.nextInt( 256 ) ) );

    }

    @Override
    public void onClick(View view) {
        if (explosion != 0) {
            sp.play( explosion, 1, 1, 0, 0, 1 );

            view.setBackgroundColor( Color.rgb( crazy.nextInt( 256 ), crazy.nextInt( 256 ), crazy.nextInt( 256 ) ) );
        }
    }

    @Override
    public boolean onLongClick(View view) {
        mm.start();
        return false;

    }
}
