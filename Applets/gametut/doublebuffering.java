
// Variablen f�r die Doppelpufferung
private Image dbImage;
private Graphics dbg;

...


/** Update - Methode, Realisierung der Doppelpufferung zur Reduzierung des Bildschirmflackerns */
public void update (Graphics g)
{
	// Initialisierung des DoubleBuffers
	if (dbImage == null)
	{
		dbImage = createImage (this.getSize().width, this.getSize().height);
		dbg = dbImage.getGraphics ();
	}

	// Bildschirm im Hintergrund l�schen
	dbg.setColor (getBackground ());
	dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);

	// Auf gel�schten Hintergrund Vordergrund zeichnen
	dbg.setColor (getForeground());
	paint (dbg);
	
	// Nun fertig gezeichnetes Bild Offscreen auf dem richtigen Bildschirm anzeigen
	g.drawImage (dbImage, 0, 0, this);
}