# EU VAT Calculator

Your goal is to calculate the price of a product, taking into account EU VAT regulations. 

Simple, right?

Start going through the levels below, and try not to skip ahead. Focus on always just implementing the **best solution for the current level you're working on**, not the overall system. 
Knowing upfront what the overall system you're working on will look like, happens exactly z-e-r-o times in real life, so you're basically cheating and fooling noone but yourself.  : ) 

*Disclaimer: the below specs should NOT be used as a guideline for production systems. They have just been pulled off the web from a quick search, and I do NOT guarantee their correctness. They are simply given as exercise material.*

## Level 1 - Who are you selling to?
The amount the buyer should pay depends on whether they are a consumer (person) or a business. 
If they are a consumer, life is easy. They pay VAT, end of story, thank you for your purchase. 

If they are a business, then, it depends a little more: 
* If they are a **Greek** business, then they pay VAT (and they can later claim it back from their input VAT). 
* If they are an **EU** business (i.e. they hold a valid EU VAT ID number), then they DO NOT pay VAT. 
* If they are a business outside of the EU (rest of world), or they do not hold a valid EU VAT ID, then they pay VAT.  

To implement the **valid VAT ID** check, you will need to rely on a 3rd-party API. This is what you will need to mock/stub out in your tests, depending on your approach. 


## Level 2 - What are you selling?
The VAT % depends on the type of product you're selling. Please see below list: 

```
ΦΠΑ 24% (Κανονικός)

Ακίνητα, αυτοκίνητα, καύσιμα, τσιγάρα, ποτά, ροφήματα, λογαριασμοί τηλεφώνων, είδη οικιακού εξοπλισμού, συσκευασμένα και μεταποιημένα είδη διατροφής, είδη σερβιριζόμενα σε καταστήματα μαζικής εστίασης, εισιτήρια μέσων μαζικής μεταφοράς, κόμιστρα ταξί και πλήθος άλλων προϊόντων και υπηρεσιών

ΦΠΑ 13% (Μειωμένος)

Κρέατα βρώσιμα, νωπά, διατηρημένα με απλή ψύξη ή κατεψυγμένα από χοιροειδή, προβατοειδή ή αιγοειδή, πετεινούς, κότες, γαλοπούλες και κουνέλια, ψάρια, φιλέτα και σάρκα ψαριών, νωπά διατηρημένα με απλή ψύξη ή κατεψυγμένα και από τα μαλάκια (σουπιές, χταπόδια και καλαμάρια), γάλα και γαλακτοκομικά προϊόντα, λαχανικά, καρποί και φρούτα βρώσιμα, δημητριακά, άμυλα και προϊόντα αλευροποιίας, ελαιόλαδο, παρασκευάσματα για τη διατροφή των παιδιών, ψωμί, ζυμαρικά, νερά φυσικά, φαρμακευτικά προϊόντα, καθετήρες, σύριγγες, είδη και συσκευές ορθοπεδικής αλλα και ηλεκτρική ενέργεια.

ΦΠΑ 6% (Υπερμειωμένος)

Ο υπερμειωμένος συντελεστής 6% ισχύει μόνο για τα φάρμακα, τα βιβλία, τις εφημερίδες, τα περιοδικά και τα εισιτήρια θεάτρων.
```

## Level 3 - Where are you selling from?
If you really want to be 100% correct, then you have to take into account that some users of your library might be located in an area in Greece, where there is a reduced VAT rate being applied. 

This is the case in some islands of the Aegean Sea. 

```
ΦΠΑ (μειωμένοι κατά 30%)

Οι μειωμένοι κατά 30% συντελεστές (ισχύουν σε ορισμένα νησιά του Αιγαίου) διαμορφώνονται σε 17%, 9% και 4%.

Τα νησιά είναι: 
* Λέσβος, Χίος, Ικαρία, Λήμνος, Κάλυμνος, Άγιος Ευστράτιος, Ψαρά, Φούρνοι, Οινούσσες, Κως, Σαμοθράκη,  Σάμος, Νίσυρος, Πάτμος, Λειψοί, Λέρος, Σύμη, Νίσυρος, Τήλος, Κάσος,  Αστυπάλαια, Καστελόριζο, Χάλκη, Αμοργός, Ίος, Ανάφη, Κίμωλος, Φολέγανδρος, Σέριφος, Σίκινος, Κύθνος,  Σκόπελος και λοιπά μη κατονομαζόμενα νησιά του Αιγαίου (πλην Κρήτης, Ευβοίας και Αργοσαρωνικού) 
```

## Level 4 - Go Commercial 
If you really want to take this to the next level, below you'll find the full spec, with all the exact descriptions of product types and VAT rates. 

https://www.e-forologia.gr/lawbank/document.aspx?digest=7DC38D0A614986E0.238AF446D398&version=2016/05/27

## Level 5 - http://foaas.com/this%20shit/you
You decide this is simply too much for your use case, so you find a commercial API (probably built by the guys who didn't back down at #4 above), that's really cheap compared to coding all this insanity. 

Refactor your code to use an external API to retrieve the VAT rate:
* for your product type,
* depending on the location of your business (in Greece).
