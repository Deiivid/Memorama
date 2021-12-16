package com.example.memorama


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.memorama.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var  binding: ActivityMainBinding
    var listaImageViewRotas = ArrayList<ImageView>()
    var listaImageView = ArrayList<ImageView>()
    var listaDePosiciones = ArrayList<Int>()
    var listaClasesImagen = ArrayList <Imagen>()

    var ImagenUno = Imagen()
    var ImagenDos = Imagen()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        listaImageView.add(binding.img0)
        listaImageView.add(binding.img1)
        listaImageView.add(binding.img2)
        listaImageView.add(binding.img3)
        listaImageView.add(binding.img4)
        listaImageView.add(binding.img5)
        listaImageView.add(binding.img6)
        listaImageView.add(binding.img7)
        listaImageView.add(binding.img8)
        listaImageView.add(binding.img9)
        listaImageView.add(binding.img10)
        listaImageView.add(binding.img11)
        listaImageView.add(binding.img12)
        listaImageView.add(binding.img13)
        listaImageView.add(binding.img14)
        listaImageView.add(binding.img15)
        listaImageView.add(binding.img16)
        listaImageView.add(binding.img17)



        listaImageViewRotas.add(binding.img0Break)
        listaImageViewRotas.add(binding.img1Break)
        listaImageViewRotas.add(binding.img2Break)
        listaImageViewRotas.add(binding.img3Break)
        listaImageViewRotas.add(binding.img4Break)
        listaImageViewRotas.add(binding.img5Break)
        listaImageViewRotas.add(binding.img6Break)
        listaImageViewRotas.add(binding.img7Break)
        listaImageViewRotas.add(binding.img8Break)
        listaImageViewRotas.add(binding.img9Break)
        listaImageViewRotas.add(binding.img10Break)
        listaImageViewRotas.add(binding.img11Break)
        listaImageViewRotas.add(binding.img12Break)
        listaImageViewRotas.add(binding.img13Break)
        listaImageViewRotas.add(binding.img14Break)
        listaImageViewRotas.add(binding.img15Break)
        listaImageViewRotas.add(binding.img16Break)
        listaImageViewRotas.add(binding.img17Break)

        ocultarImagenes()
        cargarPosicionesRandom()
        //mostrarImagenes()
    }
    fun ocultarImagenes(){
        for (i in 0..17){
            listaImageViewRotas[i].visibility= View.VISIBLE
            listaImageView[i].visibility = View.INVISIBLE
        }
    }
    fun cargarPosicionesRandom(){
        //Creando  Array Ordenado
        listaDePosiciones.add(0)
        listaDePosiciones.add(1)
        listaDePosiciones.add(2)
        listaDePosiciones.add(3)
        listaDePosiciones.add(4)
        listaDePosiciones.add(5)
        listaDePosiciones.add(6)
        listaDePosiciones.add(7)
        listaDePosiciones.add(8)
        listaDePosiciones.add(9)
        listaDePosiciones.add(10)
        listaDePosiciones.add(11)
        listaDePosiciones.add(12)
        listaDePosiciones.add(13)
        listaDePosiciones.add(14)
        listaDePosiciones.add(15)
        listaDePosiciones.add(16)
        listaDePosiciones.add(17)

        //Mostrando Array Ordenado
        Log.d("Mensaje","Original $listaDePosiciones")

        // Desordenando Array Creado
        Collections.shuffle(listaDePosiciones)
        //Mostrando Array Desordenando
        Log.d("Mensaje","Desordenado $listaDePosiciones")

        //Añadir imagenes
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())
        listaClasesImagen.add(Imagen())


        // Cada imagen tiene que tener 2 posiciones
        for (i in 0..17){
            var posicion  = listaDePosiciones[i]
            var id_drawable = 0

            when(i ){
                0,1->{
                    id_drawable=R.drawable.ic_watch
                }
                2,3 ->{
                    id_drawable=R.drawable.ic_cafe
                }
                4,5 ->{
                    id_drawable=R.drawable.ic_accessibility
                }
                6,7 ->{
                    id_drawable=R.drawable.ic_laptop
                }
                8,9->{
                    id_drawable=R.drawable.ic_arrow
                }
                10,11->{
                    id_drawable=R.drawable.ic_brightness
                }
                12,13->{
                    id_drawable=R.drawable.ic_anchor
                }
                14,15->{
                    id_drawable=R.drawable.ic_airplanemode
                }
                16,17->{
                    id_drawable=R.drawable.ic_ac
                }

            }

            //AGREGAR IMAGEN AL IMAGE VIEW
            listaImageView[posicion].setImageResource(id_drawable)
            var objetoImagen = Imagen().apply {
                this.id_vector = id_drawable
            }

            //PONEMOS CADA IMAGEN A UNA POSICION
            listaClasesImagen[posicion] = objetoImagen
        }
    }
    fun mostrarImagenes(){
        for (i in 0..17){
            listaImageViewRotas[i].visibility= View.INVISIBLE
            listaImageView[i].visibility = View.VISIBLE
        }
    }

    fun procesarImagenes(imagenView:View){
        //va a recuperar la posicion que le das click a traves del tag y recuperar el nombre
        //1º recuperamos posicion
        //recuperamos el tag
        var posicionSeleccionada = imagenView.tag.toString().toInt()
        //recuperamos el id
        var id =imagenView.resources.getResourceEntryName(imagenView.id)
        if (imagenView is ImageView){
            when(id){
                 "img0Break"->{
                mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img1Break"->{
                mostrarOcultarImagen(posicionSeleccionada,true)
                 }
                 "img2Break"->{
                mostrarOcultarImagen(posicionSeleccionada,true)
                 }
                "img3Break"->{
                mostrarOcultarImagen(posicionSeleccionada,true)
                 }
                "img4Break"->{
                mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img5Break"->{
                mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img6Break"->{
                mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img7Break"->{
                mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img8Break"->{
                    mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img9Break"->{
                    mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img10Break"->{
                    mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img11Break"->{
                    mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img12Break"->{
                    mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img13Break"->{
                    mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img14Break"->{
                    mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img15Break"->{
                    mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img16Break"->{
                    mostrarOcultarImagen(posicionSeleccionada,true)
                }
                "img17Break"->{
                    mostrarOcultarImagen(posicionSeleccionada,true)
                }

                "img0"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img1"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img2"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img3"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img4"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img5"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img6"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img7"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img8"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img9"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img10"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img11"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img12"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img13"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img14"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img15"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img16"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }
                "img17"->{
                    mostrarOcultarImagen(posicionSeleccionada,false)
                }

            }
        }
        asignarImagen(posicionSeleccionada)
    }

    fun mostrarOcultarImagen(posicion:Int,mostrar:Boolean){
        if (mostrar){
            listaImageView[posicion].visibility = View.VISIBLE
            listaImageViewRotas[posicion].visibility = View.INVISIBLE
        }else{
            listaImageView[posicion].visibility = View.INVISIBLE
            listaImageViewRotas[posicion].visibility = View.VISIBLE
        }
    }


    fun asignarImagen(posicion: Int){
        if (ImagenUno.asignada){
            ImagenDos = listaClasesImagen[posicion]
            ImagenDos.posicion = posicion
            ImagenDos.asignada = true
            if(ImagenUno.id_vector == ImagenDos.id_vector){
                mostarMensaje("Genial")
            }else{
                mostarMensaje("Error Intentalo de nuevo")
                Handler(Looper.getMainLooper()).postDelayed({
                    mostrarOcultarImagen(ImagenUno.posicion,false)
                    mostrarOcultarImagen(ImagenDos.posicion,false)
                                                            },100)



            }
            ImagenUno.asignada = false
            ImagenDos.asignada = false

        }else{
            ImagenUno = listaClasesImagen[posicion]
            ImagenUno.asignada = true
            ImagenUno.posicion = posicion


        }
    }
    fun mostarMensaje(msg:String){
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
    fun reiniciarJuego(view:View){
        var intent = getIntent()
        finish()
        startActivity(intent)
    }
}