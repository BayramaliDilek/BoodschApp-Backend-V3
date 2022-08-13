INSERT INTO picture ( file_name, content_type, url) VALUES ('aardbeien.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/aardbeien.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('appels.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/appels.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('bramen.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/bramen.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('BenEnJerry.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/BenEnJerry.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('brood.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/brood.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('cola1L.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/cola1L.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('croissant.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/croissant.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('geraspteKaas.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/geraspteKaas.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('gerooktezalm.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/gerooktezalm.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('granaKaas.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/granaKaas.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('halalboterhamworst.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/halalboterhamworst.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('IceTea.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/IceTea.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('magnum.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/magnum.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('makreelfilet.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/makreelfilet.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('perziken.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/perziken.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('spaBlauw.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/spaBlauw.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('starbucksIjskoffie.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/starbucksIjskoffie.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('stokbrood.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/stokbrood.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('Krokantschnitzel.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/Krokantschnitzel.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('frambozen.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/frambozen.jpg');
INSERT INTO picture ( file_name, content_type, url) VALUES ('ProfilePicSmallFullBodyShotV3.jpg', 'image/jpeg', 'http://localhost:8080/pictures/download/ProfilePicSmallFullBodyShotV3.jpg');

insert into person (id, person_firstname, person_lastname, person_street_name, person_house_number, person_house_number_add, person_city, person_zipcode) VALUES (1001, 'Admin', 'istrator', 'Adminweg', '164', 'C', 'Amsterdam', '1052AX');
insert into person (id, person_firstname, person_lastname, person_street_name, person_house_number, person_house_number_add, person_city, person_zipcode) VALUES (1002, 'Hans', 'Hanseblast', 'Admiralengracht', '202', 'C', 'Amsterdam', '1051AX');

INSERT INTO users (username, id, password, email, enabled, person_id, picture_file_name) VALUES ('admin', 1001, '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'admin@test.nl', TRUE, 1001, 'ProfilePicSmallFullBodyShotV3.jpg');
INSERT INTO users (username, id, password, email, enabled, person_id) VALUES ('hans', 1002, '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'hans@test.nl', TRUE, 1002);

INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('hans', 'ROLE_USER');


INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1001, 'Aardbeien 250gr', 'Fruit', 'Aardbei bevat veel vitamine C. Van de populairste fruitsoorten bevat alleen kiwi meer vitamine C. Aardbeien dragen daarnaast bij aan de inname van foliumzuur. Ze bevatten weinig calorieën.', 'Aardbeien', 2.49, 'aardbeien.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1002,  'Bramen 125gr', 'Fruit', 'Bramen behoren, evenals aardbeien, tot de grote rozenfamilie. De braam is, net als de framboos, een verzamelvrucht. De braam is zoet, soms iets zuur en sappig. Bij bramen geldt: hoe groter, hoe lekkerder.', 'Bramen', 2.79,  'bramen.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1003, 'Frambozen 125gr', 'Fruit', 'Frambozen hebben en fluweelzachte en zoete smaak. Het is beter om de frambozen niet te wassen, zo blijft de heerlijke smaak het beste bewaard. Lekker door een fruitsalade of smoothie.', 'Frambozen', 2.79,  'frambozen.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1004, 'Perziken bak 1kg', 'Fruit', 'De perzik is een steenvrucht, net als een pruim. Het vruchtvlees is zoet en sappig. Het zachte, aaibare schilletje is eetbaar. De perzik en nectarine zijn nauw verwant aan elkaar. ', 'Perziken', 2.99, 'perziken.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1005, 'Appels Pink Lady 4st', 'Fruit', 'In 1973 had de australische onderzoeker john cripps het goede idee om een golden delicious en een lady Williams natuurlijk te kruisen. Uit deze combinatie is de het appelras cripps pink geboren.', 'Appels', 3.19,  'appels.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1006, 'Casino Wit Half Gesneden Brood', 'Brood', 'Ideaal brood voor het bereiden van een tosti of dik belegde verse sandwich. Het betreft een halfbrood dat is gesneden en verpakt. Het beste brood en het lekkerste lekkers. ', 'TARWEbloem, water, bakkersgist, bakkerszout, enzymen (tarwe), meelverbeteraar: E300, moutmeel (TARWE), suiker, emulgatoren: E471,E482, plantaardige olie (raapzaad). E= door de EU goedgekeurde hulpstof', 1.39, 'brood.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1007, 'Roomboter croissant 2ststokbrood', 'Brood', 'Bakkerij de Haas is sinds 1901 een ambachtelijk familiebedrijf uit Haps. Dagelijks werken onze bakkers aan dagverse producten die in alle vroegte uitgeleverd worden aan verzorgingstehuizen, cateringbedrijven, horeca en de kleine retail. Brood en gebak gemaakt van de beste grondstoffen en met de juiste vakmanschap. Dat proef je!', 'TARWEbloem, roomboter (MELK), water, gist, suiker, EI, zout, TARWEgluten, amylase, hemicellulase, meelverbeteraar (E300).', 1.99, 'croissant.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1008, 'Stokbrood Bruin 1st', 'Brood', 'De stokbrood rustiek is na het afbakken erg lang krokant aan de buitenkant en zacht van binnen.', 'TARWEbloem, water, TARWEzemelen, bakkerszout, bakkersgist, dextrose, GERSTemoutmeel, TARWEgluten, antioxidant (E300).', 1.69,  'stokbrood.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1009, 'Coca-Cola 1L', 'Frisdranken', 'Coca-Cola is de meest favoriete frisdrank van de wereld. De 1L PET is de ideale fles om samen te delen tijdens de maaltijd. Gekoeld bewaren.', 'Sprankelend water, suiker, kleurstof: E150d, voedingszuur: E338, natuurlijke aromas (plantenextracten), waaronder cafeïne.', 1.99,  'cola1L.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1010, 'Green Tea 1.5L', 'Frisdranken', 'De allerlekkerste ice-tea die er is! Koud het lekkerst!', 'water, suiker, honing (0.18%), groene thee-extract (0,14%), natuurlijke aroma, antioxidant: ascorbinezuur, voedingszuur: ctiroenzuur, ginseng aroma.', 2.09, 'IceTea.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1011, 'Spa Reine 0,5L', 'Frisdranken', 'Spa Reine 50cl, de gezonde dorstlesser voor onderweg. Afkomstig uit het hart van de Belgische Ardennen. Puur en zeer laag gemineraliseerd.', 'Analyse (mg/I):, Ca: 5, Mg: 2, Na: 3, K: 0,5, Cl: 5, SO₄: 4, NO₃: 1,5, HCO₃: 17, SiO₂: 7, pH: 6, Droogrest: 38 mg/l.', 0.79,  'spaBlauw.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1012, 'Starbucks caramel macchiato flavour 220ml', 'Zuivel & Eieren', 'Ontdek deze klassieke favoriet, een romige mix van Starbucks Espresso Roast met stroperige, zoete karamel.', 'MELK (bevat 1,8% vet) 75%, Starbucks Arabica koffie (water, koffie-extract) (20%), suiker (4,7%), karamelaroma (bevat MELK), zuurteregelaar (kaliumcarbonaat), stabilisatoren (carrageen en guarpitmeel), emulgatoren (mono- en diglyceriden van vetzuren van plantaardige oorsprong).', 1.99,  'starbucksIjskoffie.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1013, 'Warm gerookte zalm 200g', 'Slagerij', 'Warm gerookte zalm', 'zalm, zout, voedingszuur (E270), zuurteregelaar (E262), rook.', 7.49, 'gerooktezalm.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1014, 'Makreel filet gerookt naturel 125g', 'Slagerij', 'Heerlijk gerookt!', 'Makreel, rook.', 2.19, 'makreelfilet.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1015, 'Melkan geraspte kaas jong belegen 175g', 'Kaas', 'Heerlijk op brood maar ook als snack tussendoor!', 'MELK, aardappelzetmeel, zout, zuursel, dierlijk stremsel, kleurstof: annatto norbixine/carotenen, conserveermiddel: E251.', 2.59, 'geraspteKaas.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1016, 'Grana Padano DOP 16 maanden 250g', 'Kaas', 'Grana padano is een harde italiaanse kaas gemaakt van koemelk met een wat lager vetpercentage. Grana Padano lijkt veel op de parmigiano reggiano, maar is een stuk jonger en milder van smaak.', 'rauwe melk, zout, stremsel, conserveermiddel (ei-lysozym [E1105]). Waarvan toegevoegde suikers 0.00g per 100g en waarvan toegevoegd zout 1.50g per 100g.', 4.29, 'granaKaas.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1017, 'Magnum Almond Remix 3st 255ml', 'Diepvries', 'Roomijs met amandelsmaak met een swirl van vanilleroomijs, witte chocolade (27%) met amandelstukjes (3%) en melkchocolade (7%).', 'Gerehydrateerde magere MELK, suiker, cacaoboter1, magere MELKPOEDER, water, glucosestroop, ROOM (4%), BOTERCONCENTRAAT, kokosolie, AMANDELEN, volle MELKPOEDER, fructose, LACTOSE en MELKEIWITTEN, cacaomassa1, emulgatoren (E471, zonnebloemlecithine, E442, E476), glucose-fructosestroop, gekaramelliseerde suikerstroop, stabilisatoren (johannesbroodpitmeel, guargom, carrageen), aromas (bevat SESAM), uitgeputte gemalen vanillestokjes, natuurlijk vanille aroma1 (bevat MELK), kleurstof (carotenen). Kan soja bevatten. ¹Rainforest Alliance gecertificeerd', 3.69, 'magnum.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1018, 'Ben & Jerrys Cookie Dough 465ml', 'Diepvries', 'Ben & Jerrys all-time favorite Cookie Dough bestaat uit een fairrukkelijke ijspint romige vanille-ijs met stukken chocolate chip koekjesdeeg. Gemaakt van zuivel van het duurzame "Caring Dairy" zuivelprogramma en gevuld met de lekkerste en beste chunks. So grab a spoon and start diggin! Ben & Jerrys maakt het best mogelijke ijs op de beste manier. Dit ijs bevat Fairtrade gecertificeerde cacao, suiker en vanille. Onze unieke smaken zijn gecreëerd door onze Flavour Gurus, dus elke smaak heeft zijn eigen verhaal!', 'Water, ROOM (23%), suiker, gecondenseerde magere MELK, TARWEBLOEM, sojaolie, EIGEEL1, kokosolie, BOTER, magere MELKPOEDER, zout, emulgator (SOJALECITHINE), EI1, cacaomassa, stabilisatoren (guargom, carrageen, arabische gom), vanille-extract, cacaoboter, melasse, volle MELKPOEDER, TARWEZETMEEL, spirulina, gemodificeerd zetmeel, natuurlijk vanillearoma, geconcentreerd rode bietensap, glucosestroop, kleurstoffen (riboflavine, annatto bixine, curcumine, caroteen), radijs concentraat, saffloerconcentraat, appelconcentraat, citroenconcentraat, zwarte bessenconcentraat. ¹Van vrije uitloopeieren.', 6.19, 'BenEnJerry.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1019, 'Driessen Kipschnitzel krokant', 'Slagerij', 'Grondstof Nieuwe Standaard Kip, ook wel NSK kip genoemd. Lekkere krokante schnitzels die gemaakt zijn van malse stukken kipfilet voorzien van een extra crispy buitenkant.', '90% kippenvlees, tarwebloem, gemodificeerd zetmeel (E1404), kalkoenham, conserveermiddel (E250, E261), maltodextrine, dextrose, Kaas, water, Weipoeder, boter, melkeiwit, smeltzout (E452), gistextract, zout, verdikkingsmiddel (E407), kruiden extract, plantaardig raapzaadolie, tarwemeel, rijst, gemberpoeder, chili, kardemom, komijn, zonnebloemolie', 3.99, 'Krokantschnitzel.jpg');
INSERT INTO products (product_id, product_name, product_type, product_description, product_ingredients, product_price, picture_file_name) VALUES (1020, 'Wahid Halal Kipboterhamworst', 'Slagerij', 'De Wahid kipboterhamworst is perfect om een lekker stevige boterham mee te beleggen.
Gegarandeerd Halal.', 'Mechanisch gescheiden kippenvlees 58%, water, kippenvlees 11%, aardappelzetmeel, zout, SOJA-EIWIT, voedingszuren: E262, E325, E327, stabilisatoren: E451, E450, kruiden, specerijen, antioxidanten: E316, E301, E331, conserveermiddel: E250.', 1.49, 'halalboterhamworst.jpg');

