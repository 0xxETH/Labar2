package com.example.lab_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lab_2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animals = listOf(
            Animal(
                name = "Лев",
                latin = "Panthera leo",
                description = "Лев (Panthera leo) - це великий хижий ссавець з родини котових. Леви відомі своєю маненкою, потужним тілом та гучним ревом. Вони живуть у соціальних групах, в яких самці формують величезні гареми. Леви є символом сили та влади, а їх зображення часто зустрічаються у мистецтві та культурі.",
                url = "https://upload.wikimedia.org/wikipedia/commons/7/73/Lion_waiting_in_Namibia.jpg"
            ),
            Animal(
                name = "Тигр",
                latin = "Panthera tigris",
                description = "Тигр (Panthera tigris) - це найбільший представник родини котових. Він відомий своєю величезною силою, пружністю та красивим окрасом. Тигри мешкають в різних середовищах, включаючи ліси, джунглі та тайгу. Цей маєстатичний хижак є символом величі та загадковості природи.",
                url = "data:image/jpeg;base64,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"
            ),
            Animal(
                name = "Білий ведмідь",
                latin = "Ursus maritimus",
                description = "Білий ведмідь (Ursus maritimus) - великий хижий ссавець, характерний своєю білою шерстю та пристосований до Арктики. Ці могутні ведмеді живуть переважно у льодових масивах та плавучих льодовиках, полюючи на рибу та інших морських ссавців. Вони є одними з найвідоміших символів природи й знаходяться під загрозою вимирання через зміну клімату та зниження об'єму арктичного льоду.",
                url = "https://cikavosti.com/wp-content/uploads/2017/04/d0d1b06fe5de7b77062a49bf86261ebc.jpg"
            ),
            Animal(
                name = "Кіт",
                latin = "Felis catus",
                description = "Кіт (Felis catus) - це домашня тварина, розповсюджена по всьому світу. Відомий своїм незалежним характером та прив'язаністю до людей. Коти мають різні породи, розміри та окрас, і є одними з найпопулярніших домашніх улюбленців.",
                url = "https://www.rbc.ua/static/img/_/f/_freepik__com_39_1300x820.jpg"
            ),
            Animal(
                name = "Собака",
                latin = "Canis lupus familiaris",
                description = "Собака (Canis lupus familiaris) - найвірніший друг людини. Вона має велику розмаїтість порід, від маленьких іграшкових собачок до великих та мускулистих. Собаки використовуються як компаньйони, робочі тварини, пошукові та рятувальні собаки та виконують різноманітні функції, які допомагають людям.",
                url = "https://cdnn1.img.sputnik.az/img/07e6/05/14/442092647_377:0:1657:1280_1920x0_80_0_0_701e4d6aeb8a6120356561fd02b9c7bf.jpg"
            ),
            Animal(
                name = "Вовк",
                latin = "Canis lupus",
                description = "Вовк (Canis lupus) - це хижа тварина, яка живе у зграях та має високий ступінь організації та соціальної взаємодії. Вовки мають розвинений інстинкт полювання та володіють чудовою здатністю до пристосування до різних середовищ. Вони відіграють важливу роль у природних екосистемах.",
                url = "https://sheplis.com.ua/typo3temp/fl_realurl_image/vovk-3-79.jpg"
            ),
            Animal(
                name = "Орел",
                latin = "Aquila chrysaetos",
                description = "Орел (Aquila chrysaetos) - це величний хижий птах, який є символом влади та могутності. Він має гострі зір та потужний дзьоб, що дозволяє йому полювати на інших птахів та дрібних ссавців. Орли мешкають у різних середовищах, включаючи гори, ліси та відкриті простори.",
                url = "https://www.slavyarmarka.ru/image/data/blog/Tzar-Orel.jpg"
            ),
            Animal(
                name = "Жирафа",
                latin = "Giraffa camelopardalis",
                description = "Жирафа (Giraffa camelopardalis) - це найвища тварина на Землі з довгою шиєю та великими копитами. Жирафи живуть у саванах та луках Африки, харчуючись верхівками дерев. Вони мають унікальну структуру шиї, яка дозволяє їм досягати листя.",
                url = "https://vsezhivoe.ru/wp-content/uploads/2017/11/1.jpg"
            ),
            Animal(
                name = "Слон",
                latin = "Elephas maximus",
                description = "Слон - найбільший наземний ссавець з родини слонових. Він має великі вуха, довгий хобот і величезні бивні. Слони мешкають в різних середовищах, включаючи ліси та савани. Вони відомі своєю соціальною структурою, розумом та емоційною інтелігенцією. Слони є символом сили, мудрості та довголіття.",
                url = "https://upload.wikimedia.org/wikipedia/commons/4/4c/Asian_elephant_-_melbourne_zoo.jpg"
            )
        )


        val adapter = AnimalAdapter(animals, findNavController())

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.adapter = adapter
    }
}