package com.example.bird_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import recycleview.application.bird
import recycleview.application.birdadapter



 class birdlisting :  AppCompatActivity() {

    private lateinit var  recyclerView: RecyclerView
    private lateinit var  Birdlist: ArrayList<bird>
    private lateinit var   Birdadapter: birdadapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birdlisting)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager= LinearLayoutManager(this)
        Birdlist= ArrayList()

        val sharedpreference = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)
        val birdName = sharedpreference.getString("BIRDNAME", "").toString()
        val observationDetails = sharedpreference.getString("OBSERVATIONDETAILS", "").toString()
        val selectedImageUri = sharedpreference.getString("SELECTEDIMAGEURI", "").toString()

        Birdlist.add(bird (R.drawable.birdy1, "birdName: $birdName \n observation Details: $observationDetails"))

        Birdlist.add(bird  (R.drawable.birdy1, "bird Parrot:Parrots, They are made up of four families that contain roughly 410 species in 101 generations," +
                " found mostly in tropical and subtropical regions"))
        Birdlist.add(bird  (R.drawable.birdy2, "Nicobar Pigeon: Pigeons occur worldwide except in the coldest regions and the most remote islands. About 250 species are known; two-thirds of them occur in tropical Southeast Asia, Australia, and the islands of the western Pacific, but the family also has many members in Africa"))
        Birdlist.add(bird  (R.drawable.gp, "CEBU FLOWERPECKER:Their name, Quadricolor, refers to the 4 colors of the male’s plumage: blue, red, white and yellow. " +
                "Cebu Flowerpeckers are frugivorous which means they eat only fruit and seeds "))
        Birdlist.add(bird  (R.drawable.gp2, " IMPERIAL AMAZON: The species is critically endangered. In 2019, it was estimated there were only about 50 mature individuals left in the wild, down from a previous count of hundreds. The reason for this was twofold: a serious loss of natural habitat and to make things worse, Hurricane Maria"))

        Birdlist.add(bird  (R.drawable.gp3, "CALEDONIAN: The New Caledonian Owlet-Nightjar is black with grey stripes with a long slightly rounded tail, short, rounded wings, and long, stout legs showing he is a ground feeder. Its voice is unknown but it is assumed he makes similar sounds to other Owlet-Nightjars: whistles and prolonged trilling soundss"))
        Birdlist.add(bird  (R.drawable.gp4,"COLUMBINA CYANOPIS: These lovelies are the rarest and most endangered doves in the world, found in the Cerrado region of Brazil. For 75 years they were thought to be extinct,  until 12 of this species were happily rediscovered in 2015"))

        Birdlist.add(bird  (R.drawable.gp6, "COLUMBINA CYANOPIS: The species is critically endangered. In 2019, it was estimated there were only about 50 mature individuals left in the wild, down from a previous count of hundreds. The reason for this was twofold: a serious loss of natural habitat and to make things worse, Hurricane Maria"))
        Birdlist.add(bird  (R.drawable.gp5, "CEYX MELANURUS:They have long stout legs, making them good rock climbers. " +
                "They can survive in high altitudes, with snow year round, up to a height of 1000 feet"))

        Birdlist.add(bird  (R.drawable.gp7, "LOPHORINA NIEDDA:This bird was mistaken for the wider-spread though closely related Superb Bird-of-Paradise. Recently, ornithologists recognized major differences in the two birds such as different mating dances, different female attributes and even different chirps. So they classified the Vogelkop Superb Bird-of-Paradise as a species of its own"))










        Birdlist.add(bird  (R.drawable.gu1, " Buttonquails: Turniciformes is a small order of birds, consisting of only 15 species. Buttonquails are ground-dwelling birds that inhabit warm grasslands, scrublands, and croplands of Europe, Asia, Africa, and Australia. Buttonquails are capable of flight but spend most of their time on the ground, their dull plumage blending in well with grasses and bushes."))

        Birdlist.add(bird  (R.drawable.gu2, "Order Casuariiformes:  Cassowaries and emus, order Casuariiformes, are large, flightless birds equipped with long necks and long legs. They also have shaggy, limp feathers that resemble coarse fur. These birds lack a bony keel on their sternums, or breastbones (the anchors to which a birds' flight muscles attach), and their heads and necks are nearly bald"))

        Birdlist.add(bird  (R.drawable.gu3,"Order Gruiformes: Cranes, coots, rails, crakes, bustards, and trumpeters—about 200 species in all—make up the bird order Gruiformes. The members of this group vary widely in size and appearance but are generally characterized by their short tails, long necks, and rounded wings "))

        Birdlist.add(bird  (R.drawable.gu4,"Order Gruiformes: Cuculiformes includes turacos, cuckoos, coucals, anis and the hoatzin, about 160 species in all. Cuculiformes are found worldwide, although some subgroups are more restricted in range than others. The precise classification of Cuculiformes is a matter of debate. Some experts suggest that the hoatzin is sufficiently distinct from other " +
                "Cuculiformes that it should be assigned to its own order, and the same idea has been presented for turacos "))



        Birdadapter= birdadapter(Birdlist)
        recyclerView.adapter = Birdadapter

        Birdadapter.onItemClick= {
        val intent = Intent(this, birdshare::class.java)
      intent.putExtra("bird", it)
        startActivity(intent)
         }









    }









}