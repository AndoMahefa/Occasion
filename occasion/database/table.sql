create sequence seq_utilisateur;
create table utilisateur (
    id_utilisateur varchar(20) not null default concat('USR' || LPAD(nextval('seq_utilisateur')::text, 5, '0')),
    nom_utilisateur varchar(50) not null,
    email varchar(50) not null,
    mot_de_passe varchar(10) not null,
    role varchar(20) not null,

    primary key (id_utilisateur)
);
alter table utilisateur alter column mot_de_passe type varchar(15);

create sequence seq_categorie;
create table categorie (
    id_categorie varchar(20) not null default concat('CTR' || LPAD(nextval('seq_categorie')::text, 5, '0')),
    nom_categorie varchar(50) not null,
    
    primary key (id_categorie)
);

create sequence seq_marque;
create table marque (
    id_marque varchar(20) not null default concat('MRQ' || LPAD(nextval('seq_marque')::text , 5, '0')),
    nom_marque varchar(50) not null,

    primary key (id_marque)
);

create sequence seq_modele;
create table modele (
    id_modele varchar(20) not null default concat('MDL' || LPAD(nextval('seq_modele')::text, 5, '0')),
    nom_modele varchar(50),
    id_marque varchar(20) references marque(id_marque),
    id_categorie varchar(20) references categorie(id_categorie)

    primary key (id_modele)
);

create sequence seq_energie;
create table energie (
    id_energie varchar(20) not null default concat('ERG' || LPAD(nextval('seq_energie')::text , 5, '0')),
    nom_energie varchar(50) not null,

    primary key (id_energie)
);

create sequence seq_annonce;
create table annonce (
    id_annonce varchar(20) not null default concat('ANC' || LPAD(nextval('seq_annonce')::text , 10, '0')),
    description varchar(255),
    date_annonce timestamp,
    mise_circulation timestamp,
    status int,
    id_utilisateur varchar(20) references utilisateur(id_utilisateur),
    id_categorie varchar(20) references categorie(id_categorie),
    id_marque varchar(20) references marque(id_marque),
    id_modele varchar(20) references modele(id_modele),
    id_energie varchar(20)  references energie(id_energie),

    primary key (id_annonce)
);

create table validation (
    id_etat serial,
    etat int,
    date timestamp,
    id_annonce varchar(20) references annonce(id_annonce),

    primary key(id_etat)
);
 
create sequence seq_favoris;
create table favoris (
    id_favoris varchar(20) not null default concat('FV' || LPAD(nextval('seq_favoris')::text, 10, '0')),
    id_annonce varchar(20) references annonce(id_annonce), 
    id_utilisateur varchar(20) references utilisateur(id_utilisateur),

    primary key (id_favoris)
);


-- alter table annonce add column etat int;
select * from annonce where 
    (id_categorie = 'CTR00002' or id_categorie is null) 
    and  (id_marque =  '' or id_marque is null) 
    and (id_modele =  'MDL0000' or id_modele is null) 
    and  (id_energie =  'ERG00001' or id_energie is null);