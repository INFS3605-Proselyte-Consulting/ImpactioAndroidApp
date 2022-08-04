# ImpactioAndroidApp
This is Proselyte Consulting's INFS3605 (T16A_Group3) Codebase for the WWF Sponsor Project: Community Management
Group Members: Ashiq Ahmed, Beatrice Lee, Ben Fu, Delwyn Tjahjadi, Pearl Sun, Ryan Phung, Sean Lim

This is an Android Studio based Android App which aims to bring much of the Impactio functionality to a mobile platform along with additional key innovations.
The key innovations include (but are not limited to):

Custom Curator Tags - Curators can customise and generate their own Tags attached to their profile. This is used for matchmaking

Matchmaking Algorithm - An automated process using an algorithm to sort and rank Solutions, in a way that is tailored to each Curator's profile.
Solutions have Tags associated with them, which are in turn compared to the Curator Preferences (made up of Custom Tags, SDG's and Area of Expertise).
The Solutions with a higher number of matches are shown first when the Curators "Discover Solutions".

Curation Process - Curators can provide ratings and comment on a Solution.

Notes when running the app:
Use your phone system's light mode as it was designed as such.
The UI was designed with the Pixel 3A API screen dimensions in mind although it should still look as expected in most cases thanks to Relative Layout
After registering a new user, you must login again for authentication purposes.


Admin Login Details:
email: impactioadmin@gmail.com
password: admin1234

Potential Bugs and Considerations:
The Admin dashboard is not yet fully functional, and future sprints would provide a more comprehensive administrative overview.
Currently, it acts more like a Prototype or Proof of Concept.

Also, please be aware that from our experience, Firebase is not the most reliable and consistent database and oftentimes, not all data is uploaded to the RealTime Database.
This can, and has, led to the app crashing due to missing data via null reference etc.
Furthemore the asynchronous nature of Firebase can sometimes lead to data not being readily available when it is needed to be loaded.
