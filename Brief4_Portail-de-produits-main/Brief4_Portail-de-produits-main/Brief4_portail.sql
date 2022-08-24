PGDMP     )    7                z           brief4    14.3    14.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16394    brief4    DATABASE     k   CREATE DATABASE brief4 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United Kingdom.1252';
    DROP DATABASE brief4;
                postgres    false            �            1259    16395    administration    TABLE     h   CREATE TABLE public.administration (
    id_admin character varying(5) NOT NULL,
    id_user integer
);
 "   DROP TABLE public.administration;
       public         heap    postgres    false            �            1259    16398    customer    TABLE     �   CREATE TABLE public.customer (
    id_customer character varying(5) NOT NULL,
    phone character varying(20),
    adresse character varying(30),
    id_user integer
);
    DROP TABLE public.customer;
       public         heap    postgres    false            �            1259    16401    product    TABLE     �   CREATE TABLE public.product (
    id_prd integer NOT NULL,
    name_prd character varying(50),
    price double precision,
    quantity integer,
    dateexp date,
    description character varying(200),
    id_admin character varying(5)
);
    DROP TABLE public.product;
       public         heap    postgres    false            �            1259    16404    product_id_prd_seq    SEQUENCE     �   CREATE SEQUENCE public.product_id_prd_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.product_id_prd_seq;
       public          postgres    false    211                       0    0    product_id_prd_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.product_id_prd_seq OWNED BY public.product.id_prd;
          public          postgres    false    212            �            1259    16405    users    TABLE     �   CREATE TABLE public.users (
    id_user integer NOT NULL,
    email character varying(20),
    psw character varying(15),
    fullname character varying(20)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16408    vote    TABLE     �   CREATE TABLE public.vote (
    id_prd integer NOT NULL,
    id_customer character varying(5) NOT NULL,
    appreciation boolean,
    rate integer
);
    DROP TABLE public.vote;
       public         heap    postgres    false            l           2604    16411    product id_prd    DEFAULT     p   ALTER TABLE ONLY public.product ALTER COLUMN id_prd SET DEFAULT nextval('public.product_id_prd_seq'::regclass);
 =   ALTER TABLE public.product ALTER COLUMN id_prd DROP DEFAULT;
       public          postgres    false    212    211                      0    16395    administration 
   TABLE DATA           ;   COPY public.administration (id_admin, id_user) FROM stdin;
    public          postgres    false    209   �                 0    16398    customer 
   TABLE DATA           H   COPY public.customer (id_customer, phone, adresse, id_user) FROM stdin;
    public          postgres    false    210   �       	          0    16401    product 
   TABLE DATA           d   COPY public.product (id_prd, name_prd, price, quantity, dateexp, description, id_admin) FROM stdin;
    public          postgres    false    211   6!                 0    16405    users 
   TABLE DATA           >   COPY public.users (id_user, email, psw, fullname) FROM stdin;
    public          postgres    false    213   �#                 0    16408    vote 
   TABLE DATA           G   COPY public.vote (id_prd, id_customer, appreciation, rate) FROM stdin;
    public          postgres    false    214   %                  0    0    product_id_prd_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.product_id_prd_seq', 11, true);
          public          postgres    false    212            n           2606    16413 "   administration administration_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.administration
    ADD CONSTRAINT administration_pkey PRIMARY KEY (id_admin);
 L   ALTER TABLE ONLY public.administration DROP CONSTRAINT administration_pkey;
       public            postgres    false    209            p           2606    16415    customer customer_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id_customer);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public            postgres    false    210            r           2606    16417    product product_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id_prd);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public            postgres    false    211            t           2606    16419    users users_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id_user);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    213            v           2606    16446    vote vote_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.vote
    ADD CONSTRAINT vote_pkey PRIMARY KEY (id_prd, id_customer);
 8   ALTER TABLE ONLY public.vote DROP CONSTRAINT vote_pkey;
       public            postgres    false    214    214            w           2606    16420 *   administration administration_id_user_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.administration
    ADD CONSTRAINT administration_id_user_fkey FOREIGN KEY (id_user) REFERENCES public.users(id_user);
 T   ALTER TABLE ONLY public.administration DROP CONSTRAINT administration_id_user_fkey;
       public          postgres    false    209    213    3188            x           2606    16425    customer customer_id_user_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_id_user_fkey FOREIGN KEY (id_user) REFERENCES public.users(id_user);
 H   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_id_user_fkey;
       public          postgres    false    213    3188    210            y           2606    16430 !   product fk_product_administration    FK CONSTRAINT     �   ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk_product_administration FOREIGN KEY (id_admin) REFERENCES public.administration(id_admin);
 K   ALTER TABLE ONLY public.product DROP CONSTRAINT fk_product_administration;
       public          postgres    false    209    3182    211            z           2606    16435    vote vote_id_customer_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vote
    ADD CONSTRAINT vote_id_customer_fkey FOREIGN KEY (id_customer) REFERENCES public.customer(id_customer);
 D   ALTER TABLE ONLY public.vote DROP CONSTRAINT vote_id_customer_fkey;
       public          postgres    false    3184    210    214            {           2606    16440    vote vote_id_prd_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.vote
    ADD CONSTRAINT vote_id_prd_fkey FOREIGN KEY (id_prd) REFERENCES public.product(id_prd);
 ?   ALTER TABLE ONLY public.vote DROP CONSTRAINT vote_id_prd_fkey;
       public          postgres    false    3186    211    214                  x�s4040�4����� �         I  x�m�KN�0���)fO����t��T Ub�fژ�"�i+��p.F�X�~���O�e�ȍliwZ��l��.V�|W�&c_�Gܷ��H�jQ	f��N�|��JB���&��$$���9��Q�HM�|�q�*�	��m�%�����=�Fs�I��u���b�x<�Li�r똕�[CV�)�C=��Cb'��Bb���$iq|�$�a�_b4��:��+�cN���H<��x{&���Jx����C�m{���fԦ5V)�r�VX��ę�SAN�����Ju��[�yXS^s�d�{�٥*�����M����-"}���~[�7      	   �  x�eTˎ�0];_�hF�LXfFU�u��Ɓ\���63M���<�t*E��W>ϋ�j+��*˄�3�gy��N{U�����8/��c4$�f�u����l��#7��ؑ��r�>Ng�w��8�&�zI�#y���m�)v6�K���._�-��me��&�1���^�3��q�����w���ݱ�ݽ�:R�"���/�{}[���N��?-
��BO���"����1ȏ�6%(<pMP��
ѓm`�	�j��S��uK��4�ċ��Ҟ>����4�w�l�{�'�5j��򝌑�����h�}M��󸸞d��myQ�f�6�B�o�F�l&�@�]O6J�LZ�9��������hM�l�Ao6�@���Ӟ+
�@��p�,G)EGf�$r�p5�ղb_�F�{Gk�i��՞�c�9��G�4߈?���0���~pN��a�a���7�8{�H�����I�`�95��T'���H����&�o�����Y!�BQ*�|G��mE��V��
�R��vЍdV�򓻲C� 4D�p�y���B>*M:��Z��N�H�;� ��KeIN�ܓ�ǥ,�� �����l�l�I�4�tDi{�R��0򲯞��o��TJ�]��>=�R@���y���<�l�N��N�����d]�a�������nl;d�4�S��@a�������6�Z           x�U�Kn�0E�ϫ�
������J�f��p�;�:���4���G�s�A�XiH�(�&L��c�Ji~�]g}�Vd�Z�Df;���9��
��\��4���)��۝�I����J�H�M�O͝�3���dB�Ey�IQ?���֗�=�ҡ���|ʮ��%\(�Ⴝ%�^��}[4CA/3��0���2���H+w����1P��lGE-��k�,�Μp�9K�d0�����:|c~
_���`IB�0c�e�Vt
�?ϭ��c�;x��         �   x�U��� @�3�"m`+��
���Q6���WP��fn���(ʶU�2��c��Z4�,*#�1�MP�D�� t5�J}/S�Y�� A�);F��^�б.-�-aT�҉sx���b女��d���I)� �dH�     