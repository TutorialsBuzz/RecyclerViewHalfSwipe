# RecyclerView Button Under Swipe
RecyclerView Button Under Swipe 

 [ ![Download](https://api.bintray.com/packages/hdpavan44/Halfswipe/com.tutorialsbuzz.halfswipe/images/download.svg) ](https://bintray.com/hdpavan44/Halfswipe/com.tutorialsbuzz.halfswipe/_latestVersion)


<h1>Install</h1>
<pre>
dependencies {
   ...........
   ...........
   implementation 'com.tutorialsbuzz.halfswipe:halfswipe:1.0.0'
}
</pre>
<h1>Kotlin</h1>

<pre>
object : SwipeHelper(this, recyclerView, false) {
	override fun instantiateUnderlayButton(viewHolder: RecyclerView.ViewHolder?, underlayButtons: MutableList<UnderlayButton>?) {
		
		//adding first button 
		underlayButtons?.add(
			SwipeHelper.UnderlayButton("Archive", AppCompatResources.getDrawable(this@MainActivity, R.drawable.ic_archive_black_24dp),
				Color.parseColor("#000000"), Color.parseColor("#ffffff"),

				UnderlayButtonClickListener { pos: Int ->
					//Perform click operation on button1 at given pos
				}
			))
  	     
         //similarly add more to underlayButtons list		 
		 // ..
         // ..		  
		 // ..  
		 }
	 }

</pre>
<br/>

<h1>Java</h1>

<pre>
new SwipeHelper(this, recyclerview, false) {

	@Override
	public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {

		//adding button 1
		underlayButtons.add(new UnderlayButton("Archive",
				AppCompatResources.getDrawable(MainActivity.this, R.drawable.ic_archive_black_24dp),
				Color.parseColor("#000000"), Color.parseColor("#ffffff"),

				new UnderlayButtonClickListener() {
					@Override
					public void onClick(int pos) {
						 //Perform click operation on button1 at given pos
					}
				}));
			//similarly add more to underlayButtons list		 
			// ..
			// ..		  
			// ..           
		}
   }
</pre>

<h1>Video
<br/>
<a href="https://www.youtube.com/watch?v=3B5M4puUxTk" target="_blank">	
https://www.youtube.com/watch?v=3B5M4puUxTk	
</a>	
</h1>
<br/>

<h1>Screenshot</h1>


![RecyclerViewSwipe](https://raw.githubusercontent.com/TutorialsBuzz/RecyclerViewHalfSwipe/master/android_recyclerView_button_under_swipe.png)

