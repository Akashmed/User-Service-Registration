alter table wishlist
    drop foreign key wishlist_products_id_fk;

alter table wishlist
    add constraint wishlist_products_id_fk
        foreign key (product_id) references products (id)
            on delete cascade;