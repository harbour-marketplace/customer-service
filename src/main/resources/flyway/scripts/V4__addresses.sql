CREATE TABLE IF NOT EXISTS profile.addresses
(
    id             uuid        NOT NULL DEFAULT uuidv7(),
    customer_id    uuid        NOT NULL REFERENCES customers,
    address_type   text        NOT NULL
        CONSTRAINT chk_address_type
            CHECK (address_type IN ('RESIDENTIAL', 'POSTAL')),
    address_line_1 text        NOT NULL,
    address_line_2 text,
    locality       text        NOT NULL,
    county         text,
    postcode       text,
    country_code   text        NOT NULL,
    is_primary     boolean     NOT NULL,
    created_at     timestamptz NOT NULL DEFAULT now(),
    updated_at     timestamptz NOT NULL DEFAULT now(),

    PRIMARY KEY (id)
);
