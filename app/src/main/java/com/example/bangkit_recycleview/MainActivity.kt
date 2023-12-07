package com.example.bangkit_recycleview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {

    private lateinit var foodRecycleView : RecyclerView
    private lateinit var button : Button
    private lateinit var foodArrayList : ArrayList<FoodDetail>
    lateinit var imageArticle : Array<Int>
    lateinit var heading : Array<String>
    lateinit var description : Array<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageArticle = arrayOf(
            R.drawable.apfelstrudel,
            R.drawable.kebab,
            R.drawable.kimchi,
            R.drawable.lasagna,
            R.drawable.rendang,
            R.drawable.sushi,
            R.drawable.tom_yam,
            R.drawable.paella,
            R.drawable.pecking_duck,
            R.drawable.pho,
            R.drawable.fajitas,
            R.drawable.pastadenata,
            R.drawable.sate,
            R.drawable.donuts,
            R.drawable.chilliccrab,

        )

        heading = arrayOf(
            "Apfelstrudel",
            "Kebab Turkey",
            "Kimchi",
            "Lasagna",
            "Rendang",
            "Sushi",
            "Tom Yam Goong",
            "Paella",
            "Pecking Duck",
            "Pho",
            "Fajitas",
            "Pastel De Nata",
            "Sate",
            "Donuts",
            "Chilli Crab",
        )

        description = arrayOf(
            "Apfelstrudel: Austria's Classic Apple Pastry\n \n" +
                    "Apfelstrudel, often referred to simply as \"strudel,\" is a beloved Austrian pastry known for its flaky, paper-thin layers of dough wrapped around a sweet and spiced apple filling. This iconic dessert is celebrated for its crisp texture, warm, fragrant aroma, and the delightful combination of apples, sugar, and cinnamon.\n" +
                    "\n Ingredients and Key Components\n \n" +
                    "The primary components of Apfelstrudel include the pastry dough and the apple filling. The dough is made from a mixture of flour, water, a touch of oil or butter, and sometimes a splash of vinegar, which helps create the desired flakiness. The dough is kneaded until it becomes elastic and thin enough to stretch into the thin sheets characteristic of strudel pastry.\n" +
                    "The apple filling is made by peeling, coring, and thinly slicing apples, typically varieties like Granny Smith or Braeburn. The apples are then mixed with sugar, cinnamon, breadcrumbs, and sometimes raisins or chopped nuts. The sugar and cinnamon combine to create a sweet and spicy flavor that perfectly complements the tartness of the apples.\n" +
                    "\n Preparation and Rolling \n \n" +
                    "Preparing the strudel dough is a delicate process. The dough is rolled out into a large, thin sheet and then stretched carefully by hand to achieve paper-thin layers. This technique requires skill and finesse, as the dough should be almost transparent.\n" +
                    "\n Assembly and Baking\n \n" +
                    "Once the dough is stretched to perfection, the apple filling is evenly spread across the surface. The dough is then carefully folded over the filling, creating a long, cylindrical shape. The ends are sealed, and the strudel is placed on a baking sheet, often with the seam side down. It's typically brushed with melted butter to achieve a golden-brown finish.\n" +
                    "\n Serving and Accompaniments \n \n" +
                    "Apfelstrudel is traditionally served warm, dusted with powdered sugar, and accompanied by a dollop of freshly whipped cream or a scoop of vanilla ice cream. The contrast between the warm, flaky pastry and the cold, creamy accompaniment is a delightful sensory experience.\n" +
                    "\n Cultural Significance and Popularity \n \n" +
                    "Apfelstrudel holds cultural significance in Austria and is considered one of the country's most cherished desserts. It is often enjoyed on special occasions and during holidays. Strudel-making techniques and recipes have been passed down through generations, and many Austrian families have their variations and family secrets.\n" +
                    "\n Global Appeal and Variations\n \n" +
                    "The delicious appeal of Apfelstrudel has transcended Austria's borders, making it a popular dessert in many countries. It has also inspired variations and adaptations, such as Topfenstrudel (quark strudel) and other fruit-filled strudels.\n" +
                    "In conclusion, Apfelstrudel is a timeless Austrian pastry celebrated for its delicate layers of dough and sweet, spiced apple filling. Whether savored in an Austrian café or enjoyed at home, strudel continues to captivate diners with its irresistible aroma, crisp texture, and heartwarming flavors, embodying the essence of Austrian pastry craftsmanship.",

            "Turkish Kebab: A Culinary Masterpiece\n \n" +
                    "Turkish kebabs, an integral part of Turkey's rich culinary heritage, have gained international acclaim for their tantalizing flavors and diverse preparations. These iconic dishes are enjoyed not only in Turkey but also in many countries around the world. Kebabs are a testament to the artistry of Turkish cuisine, combining the finest ingredients with meticulous cooking techniques.\n" +
                    "\n Varieties of Turkish Kebabs\n \n" +
                    "Turkey boasts an impressive array of kebabs, each with its own unique characteristics. One of the most famous is the \"Adana kebab,\" originating from the city of Adana in southern Turkey. It is made from minced lamb or beef mixed with red pepper flakes and a blend of spices. The mixture is molded onto skewers and grilled to perfection, resulting in a spicy and flavorful delight. Another renowned kebab is the \"Iskender kebab,\" hailing from Bursa. It features thinly sliced lamb or beef served over pieces of pide bread, topped with a rich tomato sauce and yogurt, creating a harmonious medley of tastes and textures.\n" +
                    "\n Cooking Techniques and Ingredients\n \n" +
                    "The key to the exquisite taste of Turkish kebabs lies in the quality of ingredients and the mastery of cooking techniques. Fresh, locally sourced meats, such as lamb, beef, or chicken, are often marinated with olive oil, herbs, and spices to enhance their flavor. The meats are then skewered and cooked over open flames or on charcoal grills, which imparts a smoky, charred aroma to the dish. The skewering process is an art in itself, ensuring that the meat is evenly cooked and retains its juiciness.\n" +
                    "\n Serving and Accompaniments\n \n" +
                    "Turkish kebabs are typically served with an array of accompaniments that elevate the dining experience. Traditional sides include lavash or pide bread, fresh salads, and a variety of mezes (small dishes), such as hummus, tzatziki, and eggplant-based spreads. Grilled vegetables like peppers, tomatoes, and onions are often served alongside the kebabs, enhancing their taste and providing a refreshing contrast. Don't forget the yogurt-based sauce known as \"cacık,\" which adds a cooling element to balance the spice and heat of some kebab variations.\n" +
                    "\n Global Influence and Popularity \n" +
                    "Turkish kebabs have transcended borders and are now cherished worldwide. Whether served in a small Turkish street vendor or an upscale international restaurant, the savory allure of a well-prepared kebab is universally appreciated. It has become a popular street food in many countries, offering a taste of Turkey's culinary heritage to diverse cultures. As kebabs continue to evolve with creative fusions and adaptations, they remain a symbol of Turkish cuisine's enduring influence on global gastronomy.\n" +
                    "In conclusion, Turkish kebabs represent the pinnacle of culinary craftsmanship, combining the finest ingredients with expert cooking techniques. Their diverse varieties cater to a wide range of tastes, and the rich tradition of kebab preparation has left an indelible mark on the global food scene. From the bustling streets of Istanbul to international eateries, Turkish kebabs continue to delight and captivate food enthusiasts with their irresistible flavors and cultural significance.\n",

            "Kimchi: The Heart of Korean Cuisine\n \n" +
                    "Kimchi, a beloved staple in Korean cuisine, is a fermented vegetable dish that has been a part of Korean culture for centuries. This spicy and pungent condiment is made primarily from Napa cabbage and Korean radishes, although there are numerous variations using other vegetables. Kimchi is not just a side dish; it is a cultural icon, a symbol of Korea, and a testament to the country's rich culinary heritage.\n" +
                    "\n Ingredients and Preparation\n \n" +
                    "The most common type of kimchi is \"Baechu Kimchi,\" which features Napa cabbage as the main ingredient. To make this kimchi, Napa cabbage is first salted to draw out excess moisture, then rinsed and mixed with a flavorful paste called \"kimchi paste.\" This paste typically consists of ingredients like Korean red pepper flakes (gochugaru), garlic, ginger, fish sauce, and sugar. Variations of kimchi can include additional ingredients such as scallions, carrots, or oysters, adding unique flavors and textures to the dish.\n" +
                    "\n Fermentation Process \n \n" +
                    "The hallmark of kimchi is its fermentation process, which not only enhances its flavor but also provides a natural means of preservation. After being prepared, kimchi is tightly packed into containers and left to ferment at room temperature for several days to weeks, depending on the desired level of fermentation. During this process, lactic acid bacteria naturally present on the vegetables proliferate, leading to the characteristic tangy and sour taste of kimchi.\n" +
                    "\n Cultural Significance\n \n" +
                    "Kimchi holds a special place in Korean culture and history. It is served with nearly every Korean meal and is considered essential to the Korean diet. Kimjang, the communal preparation of kimchi in the late fall to stock up for the winter, is a cherished tradition that brings families and communities together. Kimchi is not only a source of nourishment but also a representation of Korean identity and a symbol of hospitality.\n" +
                    "\n Versatility and Global Appeal\n \n" +
                    "In recent years, kimchi has gained popularity worldwide, thanks in part to its unique flavors and potential health benefits. It is not only enjoyed as a side dish but has also found its way into various culinary creations, from kimchi fried rice to kimchi tacos. Kimchi's probiotic properties have garnered attention for their potential digestive and immune system benefits, contributing to its status as a health food. As a result, kimchi is now readily available in international supermarkets and has become a global culinary sensation, transcending cultural boundaries and earning its place in diverse cuisines.\n" +
                    "In summary, kimchi is more than just a side dish; it is a cultural treasure with deep roots in Korean heritage. Its preparation, fermentation, and wide range of variations make it a culinary masterpiece that reflects the essence of Korean cuisine. With its unique taste and potential health benefits, kimchi has become a global sensation, appealing to food enthusiasts worldwide and introducing them to the rich flavors of Korean culture.",

            "Lasagna: A Hearty Italian Classic\n \n" +
                    "Lasagna is a quintessential Italian dish that has achieved worldwide acclaim for its hearty and comforting qualities. This layered pasta dish is a favorite in Italian cuisine and has been adopted and adapted by various cultures, each adding its own unique twist. At its core, lasagna consists of wide, flat pasta sheets layered with rich, savory fillings and a generous amount of cheese.\n" +
                    "\n Ingredients and Layering\n" +
                    "The foundation of lasagna is typically made of sheets of pasta. These sheets can be either store-bought or homemade, with the latter often considered a mark of authenticity and superior flavor. The filling of lasagna is where creativity and regional variations shine. A classic Italian lasagna may include layers of ricotta cheese mixed with egg and herbs, sautéed ground beef or pork, a tomato-based sauce, and plenty of mozzarella and Parmesan cheese. The layering process is crucial, ensuring each bite has a harmonious blend of flavors and textures. The top layer is often adorned with a final layer of cheese, creating a golden, bubbling crust when baked.\n" +
                    "\n Baking and Presentation\n \n" +
                    "Once assembled, the lasagna is baked in the oven until the pasta is cooked to perfection and the cheese is wonderfully melted and golden brown. The aroma that fills the kitchen as it bakes is irresistible. Lasagna is traditionally served in squares or slices, with each portion showcasing the beautiful layers of pasta, cheese, and filling. It's often garnished with fresh basil or parsley, adding a touch of color and freshness to the dish.\n" +
                    "\n Cultural Variations\n \n" +
                    "While the classic Italian lasagna is a timeless favorite, regional and cultural variations abound. In Italy, you'll find variations like lasagna Bolognese, which incorporates a rich meat sauce, and lasagna verde, made with spinach pasta and a creamy béchamel sauce. In the United States, there's a popular version called \"lasagna alla pizza,\" which includes pizza ingredients like pepperoni and bell peppers. Vegetarian and vegan variations of lasagna are also widespread, replacing meat with ingredients like mushrooms, spinach, or tofu ricotta for a plant-based twist.\n" +
                    "\n Global Popularity\n \n" +
                    "Lasagna's global popularity is a testament to its universal appeal. It's a dish that's cherished for its comforting qualities and versatility. Whether served at a family gathering, in a restaurant, or even as a frozen convenience meal, lasagna's delicious combination of pasta, cheese, and savory sauce has made it a beloved comfort food worldwide. It's a dish that invites creativity and adaptation while remaining true to its Italian roots, making it a timeless classic that continues to delight people of all ages and tastes.\n" +
                    "In conclusion, lasagna is a beloved Italian classic known for its layers of pasta, cheese, and savory fillings. Its versatility allows for a wide range of regional and cultural variations, making it a globally appreciated comfort food. Whether enjoyed in a traditional Italian trattoria or made at home with a personal twist, lasagna continues to capture the hearts and palates of food enthusiasts around the world.",

            "Rendang: A Flavorful Indonesian Delicacy\n \n" +
                    "Rendang is a world-renowned Indonesian dish known for its rich and complex flavors. It hails from the Minangkabau ethnic group of West Sumatra, Indonesia, and has gained immense popularity not only in its home country but also internationally. Rendang is often referred to as a \"dry curry\" due to its slow-cooked nature, which results in a thick, concentrated sauce that clings to the tender pieces of meat.\n" +
                    "\n Ingredients and Preparation\n \n" +
                    "The primary ingredient in rendang is meat, typically beef or sometimes buffalo, although variations with chicken or goat are also enjoyed. The meat is simmered in a coconut milk mixture with an array of aromatic spices and herbs. Key ingredients include galangal, lemongrass, garlic, shallots, ginger, and a variety of dried spices such as cinnamon, cardamom, and star anise. Chili peppers are added to lend heat to the dish, but the level of spiciness can be adjusted to suit individual preferences.\n" +
                    "\n Slow Cooking Process\n \n" +
                    "What sets rendang apart is its slow and meticulous cooking process. The meat is initially seared to develop a flavorful crust, and then the coconut milk and spice mixture is added. The dish is simmered over low heat for several hours, allowing the meat to absorb the rich flavors of the spices while the coconut milk reduces and thickens. This slow-cooking technique results in intensely flavored, fork-tender meat that practically melts in your mouth.\n" +
                    "\n Variations and Regional Differences\n \n" +
                    "Rendang varies not only in the choice of meat but also in regional adaptations. In West Sumatra, where it originates, rendang tends to be spicier and drier, with a pronounced coconut flavor. In other parts of Indonesia and neighboring countries like Malaysia and Singapore, rendang may have different characteristics. For instance, in Malaysia, a version called \"rendang tok\" is known for its sweet and slightly tangy taste, while rendang in Singapore is often less spicy and served as a side dish.\n" +
                    "\n Cultural Significance and Recognition\n \n" +
                    "In 2011, CNN Travel named rendang the \"World's Most Delicious Food.\" This recognition catapulted rendang into the global spotlight and solidified its status as an iconic Indonesian dish. Rendang is often served on special occasions and during festive celebrations in Indonesia. It holds cultural significance within the Minangkabau community, and the preparation of rendang is considered a labor of love, often passed down through generations.\n" +
                    "In summary, rendang is a revered Indonesian dish celebrated for its intricate flavors and slow-cooked perfection. Its blend of aromatic spices, tender meat, and creamy coconut milk creates a culinary masterpiece that has captivated taste buds around the world. Whether enjoyed in its traditional form in West Sumatra or in various adaptations globally, rendang remains an enduring symbol of Indonesian cuisine and culinary excellence.",

            "Sushi: A Japanese Culinary Art\n \n" +
                    "Sushi is a renowned Japanese culinary creation that has gained global recognition for its delicate flavors, artistic presentation, and precision in preparation. Originating in Japan, sushi has evolved over centuries, and it is now appreciated as a symbol of Japanese cuisine worldwide. Sushi is characterized by the use of vinegared rice, seafood, and a variety of ingredients, artfully combined to create a harmonious and flavorful dish.\n" +
                    "\n Ingredients and Types of Sushi\n \n" +
                    "The fundamental component of sushi is sumeshi, which is vinegared rice. This rice is meticulously prepared, seasoned with a mixture of rice vinegar, sugar, and salt to achieve the perfect balance of flavors. Various types of sushi exist, each showcasing different ingredients and preparation techniques. Nigiri sushi consists of a small mound of vinegared rice topped with thinly sliced raw fish, seafood, or other ingredients like egg or tofu. Sashimi, while not technically sushi, often accompanies sushi dishes and consists of thinly sliced raw fish or seafood served without rice.\n" +
                    "Maki sushi features rice and various ingredients wrapped in seaweed (nori) and sliced into bite-sized rolls. These rolls can be filled with anything from raw fish and vegetables to cooked eel and tempura shrimp. Sushi chefs' creativity knows no bounds, leading to a vast array of maki roll combinations. There's also chirashi sushi, where a bowl of vinegared rice is adorned with an assortment of sashimi and other toppings.\n" +
                    "\n Sushi Preparation and Presentation\n \n" +
                    "Sushi preparation is a meticulous art form. Sushi chefs, known as \"itamae\" or \"shokunin,\" undergo extensive training to perfect their knife skills, rice preparation, and ingredient selection. The freshness and quality of ingredients are paramount in sushi, and chefs often establish relationships with trusted suppliers to source the finest fish and seafood. The presentation of sushi is equally important, with an emphasis on aesthetics, balance, and color.\n" +
                    "\n Sushi Etiquette and Traditions\n \n" +
                    "Sushi comes with its own set of etiquette and traditions. Sushi is typically eaten with fingers rather than utensils, as it allows for a more tactile and sensory experience. Diners should dip the fish side (not the rice) into a small dish of soy sauce, avoiding over-saturating the rice, which can lead to the sushi falling apart. Ginger (gari) is served as a palate cleanser between different types of sushi, and wasabi, a pungent Japanese horseradish, is traditionally added by the chef to the sushi, but diners can adjust the amount to their taste.\n" +
                    "\n Global Popularity and Adaptations\n \n" +
                    "Sushi has transcended cultural boundaries and is now enjoyed worldwide. It has been adapted to suit local tastes and preferences, leading to creative variations such as California rolls, which incorporate ingredients like avocado and imitation crab. Sushi has also inspired fusion cuisine, where elements of Japanese sushi are combined with other culinary traditions to create unique dishes.\n" +
                    "In conclusion, sushi is a culinary art form that has become a global sensation. Its exquisite preparation, emphasis on quality ingredients, and adherence to tradition make it a beloved and respected cuisine. Whether enjoyed at a traditional sushiya in Japan or at a modern sushi bar in a bustling city, sushi continues to captivate diners with its balance of taste, texture, and artistry, showcasing the timeless appeal of Japanese gastronomy.",

            "Tom Yam Goong: A Flavorful Thai Soup\n \n" +
                    "Tom Yam Goong, often simply referred to as Tom Yam, is a quintessential Thai soup renowned for its bold and vibrant flavors. It's a beloved dish both in Thailand and internationally, celebrated for its combination of aromatic herbs, spicy chilies, and the savory goodness of shrimp (Goong). This hot and sour soup is a favorite choice among Thai cuisine enthusiasts, offering a delightful burst of flavors.\n" +
                    "\n Ingredients and Flavor Profile\n \n" +
                    "The key ingredients in Tom Yam Goong include shrimp, straw mushrooms, and a broth made from a fragrant blend of lemongrass, kaffir lime leaves, galangal (a type of ginger), and Thai bird's eye chilies. These ingredients infuse the soup with a complex flavor profile that balances the spiciness, sourness, and richness of the dish. Lime juice and fish sauce are added to enhance the sour and salty elements of the soup.\n" +
                    "\n Variations and Ingredients\n \n" +
                    "Tom Yam Goong comes in various regional and ingredient-specific variations. \"Goong\" refers to shrimp, but the soup can also feature chicken (Tom Yam Gai), seafood (Tom Yam Talay), or even vegetarian ingredients. The level of spiciness can be adjusted to personal preference, with some versions being quite fiery. Some variations may include coconut milk, creating a creamy and milder version known as \"Tom Kha Gai.\"\n" +
                    "\n Cooking Process\n \n" +
                    "To prepare Tom Yam Goong, the aromatic herbs and spices are first bruised or crushed to release their essential oils and flavors. Then, shrimp (or other chosen protein) and mushrooms are added to the broth, and the soup is brought to a boil. It's essential to serve Tom Yam Goong piping hot, allowing the flavors to meld together. The final result is a steaming bowl of soup that tantalizes the taste buds with its combination of spicy, sour, and savory notes.\n" +
                    "\n Cultural Significance and Popularity\n \n" +
                    "Tom Yam Goong holds cultural significance in Thailand and is a popular choice in Thai restaurants around the world. It's often enjoyed as a standalone soup or served as part of a larger Thai meal. Its intense and invigorating flavors make it a beloved comfort food, and its versatility allows for various interpretations and adaptations.\n" +
                    "In summary, Tom Yam Goong is a celebrated Thai soup known for its harmonious blend of flavors, combining the freshness of shrimp, the aromatic richness of herbs, and the fiery heat of chilies. Whether experienced in a bustling Thai street market or at a Thai restaurant abroad, Tom Yam Goong continues to captivate diners with its invigorating taste and cultural significance as a beloved Thai culinary masterpiece.",

            "Paella: The Iconic Spanish Rice Dish\n \n" +
                    "Paella is an iconic Spanish dish known for its rich flavors, vibrant colors, and cultural significance. Hailing from the Valencia region on the eastern coast of Spain, paella is a symbol of Spanish culinary tradition and has become a favorite worldwide. This savory rice dish is celebrated for its versatility, as it can feature a wide range of ingredients, making it adaptable to various tastes and preferences.\n" +
                    "\n Ingredients and Key Components\n \n" +
                    "The heart of paella is the rice, which is traditionally a short-grain variety called \"Bomba\" or \"Calasparra.\" It's known for its ability to absorb flavors and liquids while maintaining a firm texture. The rice is cooked in a wide, shallow pan called a \"paellera\" or a similar flat-bottomed pan. Saffron threads are a critical ingredient, infusing the rice with a golden hue and a delicate, earthy flavor.\n" +
                    "Paella typically includes a variety of proteins, with the most common being chicken, rabbit, and seafood (usually shrimp, mussels, and clams). It's seasoned with garlic, paprika, and fresh herbs like rosemary and thyme. Vegetables such as bell peppers, tomatoes, and green beans add color and flavor. The choice of ingredients can vary widely, leading to regional and personal variations of paella.\n" +
                    "\n Variations and Regional Styles\n \n" +
                    "Spain offers a wide array of regional paella variations, each with its own unique twist. For instance, \"Paella Valenciana\" is the traditional version featuring rabbit, chicken, and snails, while \"Paella de Mariscos\" emphasizes seafood. \"Paella Mixta\" combines both seafood and land-based proteins. In Catalonia, they have \"Paella de Mar i Muntanya,\" incorporating both seafood and meat. There are also vegetarian and vegan versions for those who prefer plant-based options.\n" +
                    "\n Cooking Process and Presentation\n \n" +
                    "The process of making paella is as much about technique as it is about ingredients. The rice is first sautéed with the garlic, spices, and vegetables, then simmered with broth and saffron. The proteins are added at specific intervals to ensure even cooking. The result is a dish with a slightly crispy layer of rice at the bottom, known as \"socarrat,\" which is highly prized for its concentrated flavors and appealing texture.\n" +
                    "Paella is often served directly from the pan it's cooked in, making it a communal and visually striking dish. The wide, shallow pan allows for even distribution of ingredients, ensuring that each serving includes a bit of everything, from the flavorful rice to the succulent proteins and aromatic vegetables.\n" +
                    "\n Cultural Significance and Popularity\n \n" +
                    "Paella is more than just a meal in Spain; it's a social and cultural event. It's often prepared outdoors, bringing together family and friends for a leisurely, festive meal. Paella has gained international popularity, with variations and adaptations enjoyed worldwide. It's a beloved symbol of Spanish cuisine, known for its tantalizing flavors, stunning presentation, and the conviviality it fosters.\n" +
                    "In conclusion, paella is a symbol of Spanish culinary artistry, celebrated for its vibrant flavors, colorful presentation, and cultural significance. Its adaptability allows for a wide range of ingredient variations, making it a cherished dish for people with diverse tastes. Whether savoring it in a Valencian village, a bustling Spanish city, or at a local restaurant abroad, paella continues to captivate diners and exemplify the rich tradition of Spanish gastronomy.",

            "Peking Duck: China's Culinary Treasure\n \n" +
                    "Peking Duck, or Beijing Roast Duck (北京烤鸭), is one of China's most famous and celebrated dishes. It is renowned for its crispy, crackling skin and tender, succulent meat. Peking Duck is a culinary treasure with a history dating back over 600 years to the Ming Dynasty, and it's an iconic representation of Chinese cuisine worldwide.\n" +
                    "\n Ingredients and Preparation\n \n" +
                    "The key ingredient, of course, is the duck, traditionally a Pekin duck, known for its tender meat and thin skin. The preparation of Peking Duck is an intricate and time-consuming process. It begins with the careful selection and cleaning of the duck. The duck is then air-dried, sometimes for several days, to achieve a crispy skin. Before roasting, the duck is often glazed with maltose syrup or honey to enhance its glistening appearance.\n" +
                    "\n Roasting and Presentation\n \n" +
                    "Peking Duck is roasted in a specialized oven, often a closed vertical oven, where the heat is controlled carefully to ensure even cooking. The duck is hung by its neck to roast, allowing the fat to drip away and the skin to crisp up. The result is a perfectly roasted duck with a crisp, caramelized skin and tender, flavorful meat.\n" +
                    "Traditionally, Peking Duck is served tableside with great ceremony. The chef or server carves the duck into thin slices, including both skin and meat, which are usually served on thin, steamed wheat pancakes. Accompaniments typically include hoisin sauce, thinly sliced scallions, and thin cucumber sticks. Diners assemble their own duck pancakes by spreading hoisin sauce on the pancake, adding slices of duck, a few scallions, and cucumber sticks, and then rolling it up like a burrito.\n" +
                    "\n Cultural Significance and Popularity\n \n" +
                    "Peking Duck has deep cultural significance in China and is often served at important gatherings and celebrations. It's considered a symbol of prosperity and is especially popular during Chinese New Year and other festive occasions. The dish's historical roots can be traced back to the imperial kitchens of the Ming and Qing Dynasties, where it was a favorite of emperors and nobility.\n" +
                    "Internationally, Peking Duck has garnered a dedicated following, and many Chinese restaurants around the world offer their own interpretations of this iconic dish. Its exquisite combination of textures and flavors has made it a favorite among food enthusiasts globally.\n" +
                    "\n Variations and Modern Adaptations\n \n" +
                    "While traditional Peking Duck remains cherished, there are modern variations and adaptations. Some restaurants offer Peking Duck sliders, Peking Duck pizza, or Peking Duck salads, showcasing the duck's flavorful meat in creative ways. Chefs also experiment with different sauces and condiments to provide unique flavor profiles while preserving the essence of the classic dish.\n" +
                    "In conclusion, Peking Duck is a culinary masterpiece and a symbol of China's rich gastronomic heritage. Its meticulous preparation, crispy skin, and tender meat make it a celebrated dish enjoyed both in China and around the world. Peking Duck continues to captivate diners with its rich history, flavorful tradition, and enduring popularity.",

            "Pho: Vietnam's Iconic Noodle Soup\n \n" +
                    "Pho (pronounced \"fuh\") is one of Vietnam's most famous and cherished culinary creations. This flavorful noodle soup is celebrated for its depth of flavor, fragrant broth, and the delightful combination of tender meat, fresh herbs, and rice noodles. Pho has not only become a symbol of Vietnamese cuisine but also gained international acclaim for its exquisite taste and cultural significance.\n" +
                    "\n Ingredients and Preparation\n \n" +
                    "Pho typically features a clear, aromatic broth made by simmering beef bones, aromatics like onions and ginger, and a blend of spices that often includes star anise, cloves, and cinnamon. The slow simmering process extracts the essence of these ingredients, resulting in a rich and flavorful broth.\n" +
                    "Thin rice noodles, called \"banh pho,\" are the foundation of the dish. These noodles are soft, flat, and slightly chewy, providing the perfect canvas for absorbing the flavorful broth. Pho is traditionally served with thinly sliced cuts of beef, which can include rare steak (tai), cooked brisket (chin), meatballs (bo vien), and tripe (sach), depending on the variation.\n" +
                    "\n Accompaniments and Garnishes\n \n" +
                    "Pho's distinctive flavor profile is enhanced by a range of garnishes and condiments. These often include fresh bean sprouts, Thai basil leaves, cilantro, lime wedges, and thinly sliced chili peppers. Hoisin sauce and sriracha are common condiments for adding sweetness and heat to taste. The garnishes and condiments provide diners with the flexibility to customize their bowl of pho to their liking, creating a personalized flavor experience.\n" +
                    "\n Variations and Regional Differences\n \n" +
                    "Pho variations can be found throughout Vietnam, with regional differences in ingredients and preparation methods. The two most well-known types are \"Pho Bo\" (beef pho) and \"Pho Ga\" (chicken pho). In the north of Vietnam, Hanoi is famous for its simpler, lighter broth with thicker noodles, while in the south, Ho Chi Minh City's version features a sweeter and spicier broth. Regional specialties may incorporate unique ingredients like seafood or pork.\n" +
                    "\n Cultural Significance and Popularity\n \n" +
                    "Pho holds deep cultural significance in Vietnam and is a symbol of national pride. It is enjoyed at any time of day, from breakfast to late-night snacks. Pho restaurants, often simple and family-run establishments, are ubiquitous throughout Vietnam and have become community gathering places. While it has ancient roots, pho's rise to international fame has made it a symbol of Vietnamese cuisine and culture on the global stage.\n" +
                    "\n Global Appeal and Adaptations\n \n" +
                    "Pho's popularity has spread far beyond Vietnam's borders, with pho restaurants found in nearly every corner of the world. It has been embraced and adapted by various cultures, leading to creative variations and interpretations. Some variations include vegetarian or vegan pho, offering plant-based protein alternatives. Pho has also inspired fusion cuisine, where elements of pho are combined with other culinary traditions to create unique dishes.\n" +
                    "In conclusion, pho is a beloved Vietnamese noodle soup celebrated for its aromatic broth, tender meat, and fresh garnishes. It's not just a dish but a cultural treasure that symbolizes Vietnamese cuisine's rich heritage and global appeal. Whether enjoyed at a street-side vendor in Hanoi or a Vietnamese restaurant abroad, pho continues to captivate diners with its exquisite flavors and cultural significance.",

            "Fajitas: A Sizzling Tex-Mex Delight\n \n" +
                    "Fajitas are a beloved Tex-Mex dish known for their sizzling presentation and bold, flavorful ingredients. This dish has become an iconic part of Tex-Mex cuisine and is celebrated for its combination of marinated and grilled meat, sautéed vegetables, and a variety of accompaniments, all typically served on a sizzling hot skillet.\n" +
                    "\n Ingredients and Key Components\n \n" +
                    "The essential elements of fajitas include marinated and grilled meat, usually beef, chicken, or shrimp, and sautéed bell peppers and onions. The marinade typically consists of ingredients like lime juice, garlic, cumin, chili powder, and paprika, which infuse the meat with a zesty, smoky flavor. The vegetables are often cooked with the meat to create a harmonious blend of flavors and textures.\n" +
                    "\n Cooking and Presentation\n \n" +
                    "Fajitas are named after the cut of beef traditionally used, which is \"faja\" in Spanish, meaning \"belt\" or \"sash.\" The beef is usually skirt steak or flank steak, though other cuts are also used. After marinating, the meat is grilled to perfection, imparting a smoky charred flavor.\n" +
                    "The sizzling presentation is an integral part of the fajita experience. The grilled meat and sautéed vegetables are typically served on a hot iron skillet, still sizzling from the heat, and brought to the table with a dramatic flair. This sizzling sound and the aromatic steam that rises from the skillet add to the sensory appeal of the dish.\n" +
                    "\n Accompaniments and Garnishes\n \n" +
                    "Fajitas are typically served with a variety of accompaniments and garnishes. These may include flour tortillas, which are used to wrap the meat and vegetables. Other common accompaniments include guacamole, sour cream, salsa, shredded cheese, and chopped cilantro. Diners can customize their fajitas by adding these toppings and condiments to suit their preferences.\n" +
                    "\n Variations and Adaptations\n \n" +
                    "While the classic fajita features marinated and grilled meat, bell peppers, and onions, there are many variations and adaptations. Seafood fajitas with shrimp or fish, as well as vegetarian or vegan options with grilled tofu or vegetables, have become popular choices. Some variations even include exotic ingredients like wild game meats.\n" +
                    "\n Cultural Significance and Popularity \n \n" +
                    "Fajitas have a rich cultural history, originating in the ranchlands of South Texas, particularly the Rio Grande Valley, where Mexican vaqueros (cowboys) cooked beef over an open flame. Over time, fajitas gained popularity and became a staple of Tex-Mex cuisine. Today, they are enjoyed not only in Texas but also across the United States and around the world, appreciated for their bold and savory flavors.\n" +
                    "\n Fajita Evolution\n \n" +
                    "Fajitas have evolved beyond the skillet and tortilla. They have inspired various culinary creations, including fajita bowls, salads, and even fajita-flavored snacks and seasonings. Fajitas have also made their way into Tex-Mex fast-food chains and upscale restaurants alike, showcasing their versatility and enduring popularity.\n" +
                    "In conclusion, fajitas are a sizzling Tex-Mex delight known for their flavorful combination of marinated and grilled meat, sautéed vegetables, and an array of accompaniments. They represent the rich culinary heritage of South Texas and have become a global favorite, cherished for their bold and savory taste and captivating presentation. Whether enjoyed at a casual Mexican restaurant or prepared at home, fajitas continue to captivate diners with their sizzling, mouthwatering appeal.",

            "Pastel de Nata: Portugal's Sweet Delight\n \n" +
                    "Pastel de Nata, often simply referred to as \"Nata,\" is one of Portugal's most beloved and iconic pastries. These creamy custard tarts are renowned for their flaky, buttery crust and rich, sweet filling. Pastel de Nata has not only become a symbol of Portuguese cuisine but has also garnered international acclaim for its irresistible taste.\n" +
                    "\n Ingredients and Key Components\n \n" +
                    "The core ingredients of Pastel de Nata include a delicate, laminated pastry dough and a creamy custard filling. The pastry dough is made from a mixture of flour, water, and butter, rolled out into thin layers and folded multiple times to create a flaky, buttery crust. The custard filling consists of egg yolks, sugar, cream, and a hint of vanilla or lemon zest for flavor. The combination of these ingredients results in a delightful contrast of textures and flavors.\n" +
                    "\n Preparation and Baking\n \n" +
                    "The process of making Pastel de Nata is intricate and requires precision. The pastry dough is rolled out thinly and lined in small, fluted tart molds, creating a delicate shell. The custard filling is poured into each pastry shell, and the tarts are baked in a hot oven until the custard is set and the top is slightly caramelized. The result is a golden-brown, blistered surface that adds a caramelized sweetness to the creamy custard.\n" +
                    "\n Historical Significance\n \n" +
                    "Pastel de Nata has a rich historical background. It is believed to have been created by Catholic monks in the 18th century at the Jerónimos Monastery in the Belem district of Lisbon. The monks used egg whites to starch their robes and had an excess of egg yolks, leading to the creation of the custard tart. The original recipe remained a well-guarded secret within the monastery until the early 19th century when the recipe was sold to a local bakery, subsequently leading to its widespread popularity.\n" +
                    "\n Serving and Accompaniments\n \n" +
                    "Pastel de Nata is typically served warm or at room temperature and is often dusted with a sprinkling of powdered sugar and cinnamon just before serving. It pairs wonderfully with a cup of coffee or espresso and is a staple for breakfast or a sweet treat throughout the day. In Portugal, Pastel de Nata is commonly enjoyed as a mid-morning snack or dessert.\n" +
                    "\n Global Popularity and Variations\n \n" +
                    "The popularity of Pastel de Nata has transcended Portugal's borders, making it a sought-after pastry around the world. It has inspired various adaptations and interpretations, with bakeries and pastry shops in many countries offering their own versions of the classic tart. In Portugal, there are also regional variations, with some places adding unique twists such as orange zest or a dash of cinnamon to the custard.\n" +
                    "In conclusion, Pastel de Nata is a treasured Portuguese pastry celebrated for its flaky crust and creamy custard filling. Its rich history, delightful flavors, and inviting appearance make it a favorite treat in Portugal and beyond. Whether enjoyed at a traditional Portuguese bakery in Lisbon or savored in a café elsewhere, Pastel de Nata continues to captivate food enthusiasts with its irresistible charm and delectable taste.",

            "Sate: A Quintessential Indonesian Dish\n \n" +
                    "Sate, often spelled \"Satay\" internationally, is a quintessential Indonesian dish that embodies the country's rich culinary heritage. These skewered and grilled delights are celebrated for their bold flavors and diverse regional variations. Sate is a beloved street food in Indonesia and is enjoyed in various forms and preparations throughout the archipelago.\n" +
                    "\n Ingredients and Variations\n \n" +
                    "In Indonesia, sate can feature a wide array of meats, with the most common options being chicken (sate ayam) and beef (sate sapi). However, you can also find lamb (sate kambing), pork (sate babi), and even exotic meats like rabbit or turtle in some regions. Each meat is typically cut into small, uniform pieces and threaded onto bamboo or metal skewers.\n" +
                    "The marinade for sate varies by region, but it often includes a mixture of coconut milk, turmeric, garlic, shallots, lemongrass, and coriander, creating a fragrant and slightly sweet flavor profile. The skewers are left to marinate for several hours or overnight to allow the flavors to permeate the meat.\n" +
                    "\n Grilling and Presentation\n \n" +
                    "Sate is traditionally grilled over open flames, typically using charcoal or wood, lending a smoky aroma and a slight char to the meat. It's cooked until the meat is tender and infused with the marinade's flavors.\n" +
                    "Sate is often served with a luscious peanut sauce, known as \"sambal kacang.\" This sauce is made from ground roasted peanuts, coconut milk, soy sauce, tamarind paste, lime juice, and a hint of palm sugar for sweetness. It's a creamy, slightly spicy condiment that perfectly complements the grilled skewers.\n" +
                    "\n Regional Variations\n \n" +
                    "Indonesia's diverse culture and geography have given rise to regional variations of sate. For example, in Bali, you'll find \"Sate Lilit,\" where minced seafood or chicken is mixed with coconut, coconut milk, lime leaves, and a blend of aromatic spices, then wrapped around bamboo sticks before grilling. In Java, you might encounter \"Sate Madura,\" famous for its sweet soy sauce-based marinade and served with rice cakes and a small bowl of clear beef broth.\n" +
                    "\n Cultural Significance and Popularity\n \n" +
                    "Sate holds immense cultural significance in Indonesia and is often enjoyed at local eateries, street food stalls, and family gatherings. It's a symbol of Indonesian culinary tradition and a favorite during celebrations and special occasions. Sate has also gained international recognition, becoming a popular dish at Indonesian restaurants worldwide.\n" +
                    "\n Global Appeal and Adaptations\n \n" +
                    "Sate's irresistible combination of succulent meat and savory peanut sauce has made it a global favorite. In addition to the traditional meat-based sate, vegetarian and vegan variations using tofu, tempeh, or mushrooms have gained popularity, making it accessible to a wider range of diners. It has also inspired fusion dishes and creative adaptations, showcasing its versatility and timeless appeal.\n" +
                    "In conclusion, Sate from Indonesia is a cherished culinary treasure celebrated for its bold flavors, diverse regional variations, and cultural significance. Whether savored at a bustling street food stall in Jakarta or a fine dining establishment abroad, Indonesian Sate continues to captivate diners with its irresistible taste and aromatic allure.",

            "Donuts: America's Beloved Fried Treat\n \n" +
                    "Donuts, also spelled \"doughnuts,\" are a beloved fried pastry that holds a special place in American culinary culture. These sweet, ring-shaped treats have a rich history and have become an iconic symbol of American comfort food, known for their wide variety of flavors, toppings, and fillings.\n" +
                    "\n Ingredients and Preparation\n \n" +
                    "The classic donut dough typically consists of flour, sugar, yeast, eggs, milk (or water), and a touch of salt. The dough is mixed, kneaded, and left to rise before being rolled out and cut into various shapes, including the familiar ring shape. The doughnuts are then deep-fried until they achieve a golden-brown exterior and a soft, fluffy interior.\n" +
                    "\n Varieties and Flavors\n \n" +
                    "One of the most distinguishing features of American donuts is the sheer variety of flavors and toppings available. Traditional glazed donuts, coated with a sugary glaze that hardens upon cooling, are a staple. Chocolate-glazed and maple-glazed donuts are also popular choices. Jelly-filled donuts feature a fruity filling, often raspberry or strawberry, injected into the center. Custard-filled and cream-filled donuts are filled with sweet, creamy fillings like vanilla or chocolate custard.\n" +
                    "Other creative variations include sprinkled donuts, which are covered in colorful sprinkles, and crullers, which have a twisted, cake-like texture. Donuts can also be topped with crushed cookies, cereal, or bacon for a playful and indulgent twist.\n" +
                    "\n Cultural Significance and Popularity\n \n" +
                    "Donuts have played a significant role in American culture, often associated with morning coffee breaks, police officers on duty, and small-town diners. They have become a symbol of comfort and nostalgia, offering a sweet escape from the ordinary.\n" +
                    "National Donut Day, celebrated on the first Friday in June, is a special day dedicated to the appreciation of donuts and their historical importance. It has roots dating back to World War I when volunteers known as \"Donut Lassies\" served donuts to American soldiers.\n" +
                    "\n Chain and Specialty Shops\n \n" +
                    "While many small, local bakeries and donut shops continue to serve up classic donuts, American culture has also embraced chain donut shops, with Dunkin' (formerly Dunkin' Donuts) and Krispy Kreme being two of the most famous. These chains have expanded internationally and introduced new flavors and innovations to the world of donuts.\n" +
                    "\n Modern Trends and Artisanal Donuts\n \n" +
                    "In recent years, artisanal donut shops have gained popularity, offering unique and gourmet donut creations. These specialty shops often experiment with unconventional flavors, incorporating ingredients like matcha, bourbon, and exotic fruits. Some artisanal donuts are even adorned with edible flowers, gold leaf, or savory ingredients like bacon and cheddar.\n" +
                    "In conclusion, donuts are a beloved American treat, cherished for their sweet and indulgent flavors, wide range of variations, and cultural significance. Whether enjoyed as a simple glazed classic or as a gourmet work of art, donuts continue to captivate diners across the United States and around the world with their delicious appeal.",

            "Chilli Crab: Singapore's Iconic Seafood Delicacy\n \n" +
                    "Chilli Crab is a celebrated and iconic seafood dish that has become synonymous with Singaporean cuisine. Known for its vibrant and flavorful sauce, this delectable dish features fresh crab cooked in a savory, spicy, and slightly sweet tomato-based gravy. Chilli Crab is a culinary masterpiece that offers a tantalizing combination of tastes and textures.\n" +
                    "\n Ingredients and Key Components\n \n" +
                    "The star of Chilli Crab is, of course, the crab itself. Mud crabs, known for their succulent and tender meat, are the preferred choice for this dish. The crab is typically chopped into manageable pieces, making it easier to enjoy.\n" +
                    "The sauce that defines Chilli Crab is a harmonious blend of ingredients, including tomatoes, chili sauce or paste, garlic, ginger, shallots, and sometimes fermented shrimp paste (belacan) for added depth of flavor. The sauce is cooked with a balance of sweetness from sugar and tanginess from lime or tamarind, creating a rich and complex flavor profile.\n" +
                    "\n Preparation and Cooking Process\n \n" +
                    "To prepare Chilli Crab, the sauce is first prepared by sautéing the aromatic ingredients and spices until fragrant. The crab pieces are then added to the sauce, allowing them to simmer and soak up the flavors. The sauce is thickened with a cornstarch slurry to achieve the desired consistency. Chopped fresh cilantro or parsley is often added for a burst of freshness.\n" +
                    "\n Serving and Accompaniments\n \n" +
                    "Chilli Crab is traditionally served with steamed or deep-fried mantou buns, which are used to soak up the delicious sauce. The sweet, fluffy mantou buns provide a delightful contrast to the spicy crab dish.\n" +
                    "Diners can get messy when enjoying Chilli Crab, as it's customary to crack open the crab shells and dig into the succulent meat with your hands or specialized tools. The communal and hands-on aspect of eating Chilli Crab adds to the dining experience's fun and interactive nature.\n" +
                    "\n Cultural Significance and Popularity\n \n" +
                    "Chilli Crab is not only a beloved dish in Singapore but also holds cultural significance. It is often featured at family gatherings, celebrations, and special occasions. The dish's popularity has grown beyond Singapore's borders, making it a must-try for visitors to the island nation.\n" +
                    "\n International Recognition and Adaptations\n \n" +
                    "Singapore's Chilli Crab has earned international recognition and has inspired adaptations and variations around the world. While the core ingredients and flavors remain true to the original, chefs may incorporate regional twists and local ingredients to create unique interpretations.\n" +
                    "In conclusion, Chilli Crab is a cherished and iconic Singaporean seafood dish, celebrated for its succulent crab meat and flavorful, spicy-sweet sauce. Whether enjoyed at a seafood restaurant in Singapore or recreated in kitchens worldwide, Chilli Crab continues to captivate diners with its rich and satisfying taste, embodying the essence of Singapore's vibrant culinary scene.",
        )

        val slicedDescriptions = description.map { it.substring(0, minOf(it.length, 20)) }

        foodRecycleView = findViewById(R.id.recycleView)
        foodRecycleView.layoutManager = LinearLayoutManager(this)
        foodRecycleView.setHasFixedSize(true)

        foodArrayList = arrayListOf<FoodDetail>()
        getFoodData()

        // image become a button
        val imageButton = findViewById<ImageView>(R.id.about_page)
        imageButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AboutMe::class.java)
            startActivity(intent)
        })

    }

    private fun getFoodData() {
        for(i in imageArticle.indices) {
            val foods = FoodDetail(imageArticle[i], heading[i], description.map { it.substring(0, minOf(it.length, 100)) + " ...." }[i])
            foodArrayList.add(foods)
        }

        var adapter = FoodAdapter(foodArrayList)
        foodRecycleView.adapter = adapter
        adapter.setOnItemClickCallback(object : FoodAdapter.OnItemClickCallback {
            override fun onItemClicked(position: Int) {
//                showSelectedHero(position)
                val intent = Intent(this@MainActivity, FoodActivity::class.java)
                intent.putExtra("heading", foodArrayList[position].heading)
                intent.putExtra("imageArticle", foodArrayList[position].titleArticle)
                intent.putExtra("desc", description[position])
                startActivity(intent)
            }

        })
    }

    private fun showSelectedHero(food: FoodDetail) {
        Toast.makeText(this, "Kamu memilih " + food.heading, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu:  Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item2 -> {
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item3 -> {
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}