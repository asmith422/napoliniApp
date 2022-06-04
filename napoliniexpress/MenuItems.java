package com.example.napoliniexpress;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.napoliniexpress.adapters.DetailMenuAdapter;
import com.example.napoliniexpress.models.DetailMenuModel;

import java.util.ArrayList;
import java.util.List;

public class MenuItems extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailMenuModel> detailMenuModelList;
    DetailMenuAdapter menuAdapter;
    ImageView imageView;
    //Button btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_items);

        getSupportActionBar().hide();

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.menu_items_rec);
        imageView = findViewById(R.id.category_img);
        //btnCart = findViewById(R.id.btn_item_view_cart);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailMenuModelList = new ArrayList<>();
        menuAdapter = new DetailMenuAdapter(detailMenuModelList);
        recyclerView.setAdapter(menuAdapter);

        if(type != null && type.equalsIgnoreCase("Appetizers")){
            detailMenuModelList.add(new DetailMenuModel(R.drawable.appetizers, "Golden Fried Chicken Tenders", "5 tenders served with a side of honey mustard -or- ketchup", "11.40"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.appetizers, "Garlic Bread", "a loaf of Italian bread baked with fresh garlic, virgin olive oil & imported spices", "4.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.appetizers, "Garlic Bread with melted mozzarella", "", "5.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.appetizers, "Mozzarella Sticks", "6 sticks served with a side of tomato sauce", "9.20"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.appetizers, "Fried Calamari", "golden fried calamari served with marinara sauce", "14.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.appetizers, "Eggplant Rollatini", "2 fresh battered eggplant rolled with seasoned ricotta cheese topped with tomato sauce & melted mozzarella", "11.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.appetizers, "Buffalo Wings", "8 Louisiana style Buffalo Wings served with celery, carrots and our homemade blue cheese sauce", "12.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.appetizers, "French Fries", "Add Mozzarella or American cheese + $2.00", "6.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.appetizers, "Calamari Arrabiatta", "fried calamari, tossed in a spicy arrabiatta sauce with roasted peppers", "15.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.appetizers, "Buffalo Calamari", "fried calamari, tossed in a spicy buffalo sauce served with side of house made blue cheese", "15.50"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Bar Pie")){
            imageView.setImageResource(R.drawable.barpie);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.barpie, "Bar Pie", "ultra thin personal pizza topped with fresh plum tomato sauce and mozzarella cheese", "9.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.barpie, "Whole Wheat Bar Pie", "ultra thin personal whole wheat pizza topped with fresh plum tomato sauce and mozzarella cheese", "10.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.barpie, "Salad Bar Pie", "chopped salad spread on our thin bar pie crust topped with shredded mozzarella and our own balsamic vinaigrette", "12.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.barpie, "Caesar Chicken Bar Pie", "", "13.95"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Salads")){
            imageView.setImageResource(R.drawable.salad);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.salad, "Fresh Garden Salad SM", "crisp iceberg lettuce, grape tomatoes, seedless cucumbers, red bell peppers, carrots, black olives & red onions served with our 100% olive oil and balsamic vinaigrette", "6.55"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.salad, "Fresh Garden Salad LG", "crisp iceberg lettuce, grape tomatoes, seedless cucumbers, red bell peppers, carrots, black olives & red onions served with our 100% olive oil and balsamic vinaigrette", "8.30"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.salad, "Caesar Salad SM", "romaine lettuce tossed with homemade garlic croutons, parmesan cheese & our creamy caesar dressing", "6.80"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.salad, "Caesar Salad LG", "romaine lettuce tossed with homemade garlic croutons, parmesan cheese & our creamy caesar dressing", "8.65"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.salad, "Gorgonzola Salad", "mixed field greens tossed with honey roasted walnuts, red onions & crumbled gorgonzola cheese in a light raspberry vinaigrette", "10.45"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.salad, "Farmers Market Salad LG", "mixed field greens, crumbled goat cheese, sun-dried cranberries, grape tomato and honey roasted walnuts with our 100% olive oil and balsamic vinaigrette", "10.45"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.salad, "Greek Salad SM", "crisp iceberg & romaine lettuce, calamata olives, grape tomatoes, green peppers, cucumbers, red onions & feta cheese", "7.29"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.salad, "Greek Salad LG", "crisp iceberg & romaine lettuce, calamata olives, grape tomatoes, green peppers, cucumbers, red onions & feta cheese", "9.40"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.salad, "Antipasto", "our garden salad topped with provolone wedges, rolled ham, genoa salami, marinated mushrooms, broccoli florets & shredded mozzarella", "11.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.salad, "Buffalo Chicken Salad", "tender Buffalo Chicken pieces, crisp romaine lettuce, celery, shredded mozzarella, diced tomato, carrots and blue cheese dressing", "12.00"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Side Orders")){
            imageView.setImageResource(R.drawable.sideorder);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.sideorder, "Sautéed Broccoli", "", "8.30"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.sideorder, "Fried Chicken Cutlets -or- Fresh Grilled Chicken", "", "8.65"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.sideorder, "Homemade Meatball", "Order of 5", "8.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.sideorder, "Fresh Sautéed Sausage", "", "8.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.sideorder, "Sautéed Broccoli Rabe", "", "9.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.sideorder, "Sautéed Spinach", "", "8.25"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Soups")){
            imageView.setImageResource(R.drawable.soup);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.soup, "Tomato Florentine Soup", "creamy tomato and spinach soup", "7.10"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.soup, "Pasta e Fagioli", "spaghetti confetti and white cannellini beans in a roasted garlic and tomato broth", "7.10"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.soup, "Tortellini in Brodo", "cheese tortellini pasta served in a light chicken broth", "7.10"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.soup, "Stracciatella Romana", "chicken broth, spinach, and egg drop soup with tortellini pasta", "7.10"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Pasta")){
            imageView.setImageResource(R.drawable.pasta);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Alfredo", "classic aged parmesan cream sauce", "16.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Alfredo Lunch", "classic aged parmesan cream sauce", "12.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne alla Vodka", "imported prosciutto & scallions sautéed in a creamy pink vodka sauce", "16.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne alla Vodka Lunch", "imported prosciutto & scallions sautéed in a creamy pink vodka sauce", "12.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Caprese", "garden tomato basil sauce, tossed with fresh mozzarella", "13.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Caprese Lunch", "garden tomato basil sauce, tossed with fresh mozzarella", "11.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Rigatoni Marinara", "“Old World Style” garlic & herb plum tomato sauce", "12.60"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Rigatoni Marinara Lunch", "“Old World Style” garlic & herb plum tomato sauce", "11.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Rigatoni Fiorentina", "fresh spinach, grilled chicken, mozzarella and Rigatoni pasta sautéed in a creamy pink sauce", "17.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Rigatoni Fiorentina Lunch", "fresh spinach, grilled chicken, mozzarella and Rigatoni pasta sautéed in a creamy pink sauce", "13.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Broccoli", "fresh broccoli florets & cherry tomatoes sautéed in a light garlic & olive oil brodino", "15.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Broccoli Lunch", "fresh broccoli florets & cherry tomatoes sautéed in a light garlic & olive oil brodino", "12.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Rigatoni Bolognese", "“Southern Italian” style, meat sauce with a touch of cream", "14.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Rigatoni Bolognese Lunch", "“Southern Italian” style, meat sauce with a touch of cream", "12.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Pomodoro", "traditional Italian tomato sauce", "10.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Pomodoro Lunch", "traditional Italian tomato sauce", "9.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Pomodoro With 3 meatballs", "traditional Italian tomato sauce with 3 meatballs", "15.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Pomodoro With 3 meatballs Lunch", "traditional Italian tomato sauce with 3 meatballs", "11.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Pomodoro With sliced sausage", "traditional Italian tomato sauce with sliced sausage", "15.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Pomodoro With sliced sausage Lunch", "traditional Italian tomato sauce with sliced sausage", "11.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Shrimp Marinara", "6 jumbo shrimp sautéed in a marinara style plum tomato sauce", "19.60"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Shrimp Marinara Lunch", "6 jumbo shrimp sautéed in a marinara style plum tomato sauce", "16.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Shrimp Fra Diavolo", "6 jumbo shrimp sautéed in a spicy fra diavolo plum tomato sauce over your choice of pasta", "19.60"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Shrimp Fra Diavolo Lunch", "6 jumbo shrimp sautéed in a spicy fra diavolo plum tomato sauce over your choice of pasta", "16.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Calamari Marinara", "fresh calamari sautéed in a marinara style plum tomato sauce", "19.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Calamari Fra Diavolo", "fresh calamari sautéed in a spicy fra diavolo plum tomato sauce over your choice of pasta", "19.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Meat Sauce", "Hearty ground beef, meat sauce tossed with penne", "14.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Meat Sauce Lunch", "Hearty ground beef, meat sauce tossed with penne", "12.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Spaghetti Aglio e Olio (garlic & oil)", "extra virgin olive oil, fresh roasted garlic, Italian parsley and herbs tossed with spaghetti pasta", "13.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Spaghetti Aglio e Olio (garlic & oil) Lunch", "extra virgin olive oil, fresh roasted garlic, Italian parsley and herbs tossed with spaghetti pasta", "12.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Rigatoni Alfano", "grilled chicken, sun-dried tomatoes, fresh spinach and rigatoni pasta sauteed in a roasted garlic and olive oil brodino", "16.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Rigatoni Alfano Lunch", "grilled chicken, sun-dried tomatoes, fresh spinach and rigatoni pasta sauteed in a roasted garlic and olive oil brodino", "12.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Oreganata", "penne pasta sautéed with 6 jumbo shrimp and fresh spinach in a garlic and white wine sauce topped with seasoned bread crumbs", "19.60"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Oreganata Lunch", "penne pasta sautéed with 6 jumbo shrimp and fresh spinach in a garlic and white wine sauce topped with seasoned bread crumbs", "16.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Napolini", "fried chicken cutlet, fresh mushrooms and spinach in a roasted garlic parmesan cream sauce", "15.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pasta, "Penne Napolini Lunch", "fried chicken cutlet, fresh mushrooms and spinach in a roasted garlic parmesan cream sauce", "12.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.bakedpasta, "Homemade Meat Lasagna", "", "14.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.bakedpasta, "Baked Ravioli", "", "13.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.bakedpasta, "Baked Ziti", "", "13.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.bakedpasta, "Baked Ziti Lunch", "", "10.95"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Heros & Dinners")){
            imageView.setImageResource(R.drawable.heros);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Meatball Parmigiana Hero", "", "10.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Meatball Parmigiana", "", "15.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Chicken Parmigiana Hero", "Alla Vodka Add $2.50", "10.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Chicken Parmigiana", "Alla Vodka Add $2.50", "16.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Chicken Parmigiana Lunch", "Alla Vodka Add $2.50", "11.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Veal Parmigiana Hero", "", "13.10"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Veal Parmigiana", "", "18.65"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Veal Parmigiana Lunch", "", "13.60"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Eggplant Parmigiana Hero", "", "11.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Eggplant Parmigiana", "", "16.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Eggplant Parmigiana Lunch", "", "12.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Sausage Parmigiana Hero", "", "11.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Sausage Parmigiana", "", "16.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Sausage Parmigiana Lunch", "", "12.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Sausage Peppers, Onion Hero", "(Red or White) Mozzarella Add $1.00", "11.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Sausage Peppers, Onion", "(Red or White) Mozzarella Add $1.00", "16.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Sausage Peppers, Onion Lunch", "(Red or White) Mozzarella Add $1.00", "12.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Jumbo Shrimp Parmigiana Hero", "", "14.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Jumbo Shrimp Parmigiana", "", "19.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Jumbo Shrimp Parmigiana Lunch", "", "14.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Pepper & Egg Hero", "", "9.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.heros, "Chicken Club Hero", "marinated Grilled chicken -OR- Fried chicken cutlets with shredded lettuce and sliced tomatoes (Mayo & balsamic dressing available on the side)", "11.00"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Entrees")){
            imageView.setImageResource(R.drawable.entrees);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.entrees, "Chicken Vesuvio", "fresh breast of grilled chicken marinated in balsamic vinegar & seasonings, topped with fresh sautéed spinach, broccoli & mushrooms", "18.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.entrees, "Chicken Franchese", "fresh battered breast of chicken sautéed in a white wine, lemon & butter sauce", "19.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.entrees, "Chicken Marsala", "fresh breast of chicken sautéed in a “classic” Marsala wine sauce with fresh mushrooms", "19.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.entrees, "Eggplant Rollatini", "fresh battered eggplant rolled with seasoned ricotta, baked “parmigiana style” with tomato sauce & mozzarella cheese", "19.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.entrees, "Chicken Verde", "fresh battered breast of chicken sauteed in a white wine, lemon & butter sauce topped with fresh broccoli and melted mozzarella", "19.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.entrees, "Carmela’s Chicken", "sauteed chicken breast simmered in a garlic alfredo sauce with spinach and gorgonzola cheese", "20.95"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Panini & Wraps")){
            imageView.setImageResource(R.drawable.wraps);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.wraps, "Grilled Eggplant Panini", "fresh grilled eggplant, fresh mozzarella, roasted peppers & field greens", "8.10"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.wraps, "Grilled Chicken Panini", "fresh grilled chicken, fresh mozzarella, crisp romaine lettuce & sliced tomatoes", "7.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.wraps, "Flat Iron Steak Panini", "marinated grilled skirt steak, frizzled onions, mixed field greens, sliced tomatoes and our homemade steak sauce", "9.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.wraps, "Broccoli Rabe & Chicken Panini", "sautéed broccoli rave, grilled chicken, fresh mozzarella and roasted red peppers on our homemade panini bread", "8.15"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.wraps, "Buffalo Chicken Panini", "fried chicken, buffalo sauce, lettuce, mozzarella and blue cheese dressing", "8.65"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.wraps, "Caesar Grilled Chicken Wrap", "grilled chicken, romaine lettuce, croutons and our creamy parmesan Caesar dressing", "10.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.wraps, "Chicken BLT Wrap", "fried chicken cutlet, crisp bacon, tomato, iceberg lettuce and ranch dressing", "10.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.wraps, "Buffalo Chicken Wrap", "tender Buffalo chicken, mixed greens, mozzarella and blue cheese dressing", "10.95"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Calzones & Rolls")){
            imageView.setImageResource(R.drawable.calzone);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.calzone, "Calzone", "pizza dough pocket filled with seasoned ricotta & mozzarella cheese", "7.60"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.calzone, "Sausage Roll", "pizza dough rolled with fresh sautéed Italian sausage, peppers, onions, mozzarella cheese & tomato sauce", "7.60"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.calzone, "Chicken Roll", "pizza dough rolled with tender strips of fresh chicken cutlet, tomato sauce & mozzarella cheese", "7.60"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.calzone, "Buffalo Chicken Roll", "", "8.15"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.calzone, "Spinach & Broccoli Pinwheel", "", "3.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.calzone, "Pepperoni Pinwheel", "", "3.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.calzone, "Buffalo Chicken Pinwheel", "", "3.40"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.calzone, "Garlic Knots (6)", "", "3.50"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Gluten Free")){
            imageView.setImageResource(R.drawable.glutenfree);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.glutenfree, "Gluten Free Pizza", "10” personal gluten free pie topped with plum tomato sauce and mozzarella cheese", "12.50"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Pizza")){
            imageView.setImageResource(R.drawable.pizza);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Neopolitan Pie", "mozzarella cheese & tomato sauce Round – 18” (8 slices)", "18.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Neopolitan Slice", "", "3.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Sicilian Pie", "mozzarella cheese & tomato sauce Square – 12” x 18” (9 slices)", "19.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Sicilian Slice", "", "3.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Gluten Free Pizza", "“10” personal gluten free pie topped with plum tomato sauce and mozzarella cheese", "12.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Cauliflower Crust Pizza", "organic tomato sauce and mozzarella", "13.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "“Grandma” Pizza Pie", "extra thin crust pan pizza layered with mozzarella & spotted with a flavorful herbed “San Marsano” tomato sauce", "18.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Grandma Slice", "extra thin crust pan pizza layered with mozzarella & spotted with a flavorful herbed “San Marsano” tomato sauce", "3.30"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Buffalo Pizza Pie", "tender pieces of spicy buffalo chicken baked on top of homemade bleu cheese dressing, topped with mozzarella cheese", "31.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Buffalo Slice", "tender pieces of spicy buffalo chicken baked on top of homemade bleu cheese dressing, topped with mozzarella cheese", "4.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "White Pizza Pie", "crispy round pie topped with mozzarella, aged Romano cheese, seasoned ricotta & a dash of fresh garlic & virgin olive oil", "22.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "White Pizza Slice", "crispy round pie topped with mozzarella, aged Romano cheese, seasoned ricotta & a dash of fresh garlic & virgin olive oil", "3.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Crostina Pizza", "thin crust garlic basted pan pizza topped with fresh sliced garden tomatoes, homemade fresh mozzarella & basil drizzled with a touch of virgin olive oil", "30.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Baked Ziti Pizza", "crispy round pie topped with traditional baked ziti, mozzarella & tomato sauce", "24.00"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Margherita Pizza", "crispy round pie topped with a fresh tomato sauce, shaved pecorino romano, fresh mozzarella, basil and a whisper of garlic", "26.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Margherita Slice", "crispy round pie topped with a fresh tomato sauce, shaved pecorino romano, fresh mozzarella, basil and a whisper of garlic", "4.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Marinara Pizza", "“Old World” pan pizza topped with our traditional garlic & herb plum tomato sauce, aged Romano cheese, fresh basil & a touch of virgin olive oil", "19.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Marinara Slice", "“Old World” pan pizza topped with our traditional garlic & herb plum tomato sauce, aged Romano cheese, fresh basil & a touch of virgin olive oil", "3.30"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Grandma Alla Vodka Pizza", "Thin crust sicilian dough layered with mozzarella, romano cheese and our creamy pink vodka sauce. No Meat.", "21.75"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Neopolitan House Special Pizza", "a hearty combination of fresh sausage, meatballs, pepperoni, mushrooms, peppers, onion, tomato sauce & extra cheese (Anchovies available by request only)", "27.50"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.pizza, "Sicilian House Special Pizza", "a hearty combination of fresh sausage, meatballs, pepperoni, mushrooms, peppers, onion, tomato sauce & extra cheese (Anchovies available by request only)", "28.50"));
            menuAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Desserts")){
            imageView.setImageResource(R.drawable.dessert);
            detailMenuModelList.add(new DetailMenuModel(R.drawable.dessert, "Cannoli", "", "4.95"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.dessert, "N.Y. Cheesecake", "", "5.25"));
            detailMenuModelList.add(new DetailMenuModel(R.drawable.dessert, "Cookies 8oz", "Rainbow, Black & White, or Chocolate Chip", "7.25"));
            menuAdapter.notifyDataSetChanged();
        }
/*
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CartFragment.class));
            }
        });

 */


    }
}
