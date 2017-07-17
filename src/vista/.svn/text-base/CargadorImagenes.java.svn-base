package vista;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class CargadorImagenes {

    Map<String, ImageIcon> iconos = new HashMap<String, ImageIcon>();

    static CargadorImagenes instance = null;

    private CargadorImagenes() {
    }

    public static CargadorImagenes getInstance() {
        if (instance == null)
            instance = new CargadorImagenes();
        return instance;
    }

    public ImageIcon getIconForName(String name, int ancho, Integer alto) {

        String key = name + "_" + Integer.toString(ancho) + "x"
                + Integer.toString(alto);

        ImageIcon icon = iconos.get(key);
        if (icon == null) {
            String filename = "Imagenes/"+name+".png";
            if (getClass().getClassLoader().getResourceAsStream(filename) != null)
            	icon = new ImageIcon(getClass().getClassLoader().getResource(filename));
            else if (new File(filename).exists())
            	icon = new ImageIcon(filename);
            else return null;
            
            Image image = icon.getImage();
            image = image.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            icon.setImage(image);
            iconos.put(key, icon);
        }
        return icon;
    }

    // Se obtiene la imagen original, sin redimensionar.
    public ImageIcon getIconForName(String name) {
        ImageIcon icon = iconos.get(name);
        if (icon == null) {
            icon = new ImageIcon("images/" + name + ".gif");
            iconos.put(name, icon);
        }
        return icon;
    }

};
