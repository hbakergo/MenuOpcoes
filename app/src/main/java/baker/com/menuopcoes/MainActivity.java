package baker.com.menuopcoes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //usado para acessar em memória o objeto em memória(constraintLayout) que está gerenciando
        // o layout dessa activity
        layout = findViewById(R.id.layoutPrincipal);
    }

    //método chamado quando o usuário abrir o menu, somente na primeira vez
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.principal_opcoes, menu); //infla o layout que criamos no objeto menu
        return true;
    }

    private void mostrarMensagem(String texto){
        Toast.makeText(this,
                        texto,
                        Toast.LENGTH_LONG).show();
    }

    //método que vai tratar o evento de um item do menu, onclick
    public void usarDados(MenuItem item){
        item.setChecked(!item.isChecked()); //usado visualmente para checar ou não o item

    }

    //faz par com o onCreateOptionsMenu que lidam com menu de opções, é chamado toda vez que uma opção
    //de um menu item é chamada
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuItemSalvar:
                mostrarMensagem(getString(R.string.salvar) +
                                getString(R.string.foi_clicado));
                return true;
            case R.id.menuItemExcluir:
                mostrarMensagem(getString(R.string.excluir) +
                        getString(R.string.foi_clicado));
                return true;
            case R.id.menuItemAzul:
                item.setChecked(true);
                layout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.menuItemVermelho:
                item.setChecked(true);
                layout.setBackgroundColor(Color.RED);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}