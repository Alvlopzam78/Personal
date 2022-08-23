-- TAREA 2
--creamos la table
create table emails(
	id_registro numeric(4,0) constraint pk_emails primary key,
	nombre varchar(100) not null,
	email varchar(100) not null 
);

create sequence emails_seq start 1 increment 1;
alter table emails alter column id_registro set default nextval('emails_seq'); 

--agregamos los valores
insert into emails 
(nombre, email)
values
('Wanda Maximoff', 'wanda.maximoff@avengers.org'),
('Pietro Maximoff', 'pietro@mail.sokovia.ru'),
('Erik Lensherr', 'fuck_you_charles@brotherhood.of.evil.mutants.space'),
('Charles Xavier', 'i.am.secretely.filled.with.hubris@xavier-school-4-gifted-youngste.'),
('Anthony Edward Stark', 'iamironman@avengers.gov'),
('Steve Rogers', 'americas_ass@anti_avengers'),
('The Vision', 'vis@westview.sword.gov'),
('Clint Barton', 'bul@lse.ye'),
('Natasja Romanov', 'blackwidow@kgb.ru'),
('Thor', 'god_of_thunder-^_^@royalty.asgard.gov'),
('Logan', 'wolverine@cyclops_is_a_jerk.com'),
('Ororo Monroe', 'ororo@weather.co'),
('Scott Summers', 'o@x'),
('Nathan Summers', 'cable@xfact.or'),
('Groot', 'iamgroot@asgardiansofthegalaxyledbythor.quillsux'),
('Nebula', 'idonthaveelektras@complex.thanos'),
('Gamora', 'thefiercestwomaninthegalaxy@thanos.'),
('Rocket', 'shhhhhhhh@darknet.ru');

--agregué más valores a la tabla para probar más a fondo el query
insert into emails 
(nombre, email)
values 
('TChalla', 'wakanda for ever@im_dead.rip'), --no valido
('Mantis', 'mant¡s@guardians.com'), --no valido
('Peter Parker','peter&parker@avenegers.com'), --no valido 
('Steven Grant','moonkn!ght@ihaveissues.help'), --no valido 
('Marc Spector','marc..spector@fuckyousteven.org'), --no valido 
('Khonshu', 'laylaisbetterthanmarc?@ithinkso.com'), --no validio
('Sam Wilson', 'captainamerica2.0@lost.avenger.com'), --valido 
('James Buchanan Barnes','IShouldHaveBeen@CaptainAmerica.com'), --valido 
('Sharon Carter','13@shield.com'); --valido

--realizamos el query 
select * 
from emails e
where e.email not like '%@%.%' or e.email like '%.' or e.email like '%..%' or e.email like '%@%@%' or e.email like '@%'
or e.email like '%!%' 
or e.email like '%&%'
or e.email like '%/%'
or e.email like '%\%'
or e.email like '%|%'
or e.email like '%"%'
or e.email like '%·%'
or e.email like '%#%'
or e.email like '%$%'
or e.email like '%&%'
or e.email like '%(%'
or e.email like '%)%'
or e.email like '%=%'
or e.email like '%?%'
or e.email like '%¿%'
or e.email like '%¡%'
or e.email like '%^%'
or e.email like '%*%'
or e.email like '%[%'
or e.email like '%+%'
or e.email like '%]%'
or e.email like '%{%'
or e.email like '%}%'
or e.email like '%;%'
or e.email like '%:%'
or e.email like '% %'
or e.email like '%>%'
or e.email like '%<%'
or e.email like '%¨%'
;

-- Ahora bien, podemos hacer otro query.
-- De acuerdo con la fuente citada, los mails con caracteres especiales sí son validos. Por lo tanto, podemos simlificar el query de la siguiente manera;
-- fuente: https://help.returnpath.com/hc/en-us/articles/220560587-What-are-the-rules-for-email-address-syntax-
select * 
from emails e
where e.email not like '%@%.%' or e.email like '%.' or e.email like '%..%' or e.email like '%@%@%' or e.email like '@%' or e.email like '%@' or e.email like '% %' or e.email like '%@@%' or e.email like '%@.%' or e.email like '%.@';

