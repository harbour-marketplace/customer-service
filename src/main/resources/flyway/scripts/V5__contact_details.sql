CREATE TABLE IF NOT EXISTS profile.contact_details
(
    id            uuid        NOT NULL DEFAULT uuidv7(),
    customer_id   uuid        NOT NULL REFERENCES customers,
    contact_type  text        NOT NULL
        CONSTRAINT chk_contact_type
            CHECK (contact_type IN ('EMAIL', 'TELEPHONE')),
    contact_value text        NOT NULL,
    is_primary    boolean     NOT NULL,
    created_at    timestamptz NOT NULL DEFAULT now(),
    updated_at    timestamptz NOT NULL DEFAULT now(),

    PRIMARY KEY (id)
);
