CREATE TABLE IF NOT EXISTS profile.customers
(
    id         uuid        NOT NULL DEFAULT uuidv7(),
    status     text        NOT NULL DEFAULT 'ACTIVE'
        CONSTRAINT chk_customer_status
            CHECK (status IN ('ACTIVE', 'SUSPENDED')),
    created_at timestamptz NOT NULL DEFAULT now(),
    updated_at timestamptz NOT NULL DEFAULT now(),

    PRIMARY KEY (id)
);
