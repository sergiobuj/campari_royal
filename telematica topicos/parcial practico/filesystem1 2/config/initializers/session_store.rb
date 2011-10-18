# Be sure to restart your server when you modify this file.

# Your secret key for verifying cookie session data integrity.
# If you change this key, all old sessions will become invalid!
# Make sure the secret is at least 30 characters and all random, 
# no regular words or you'll be exposed to dictionary attacks.
ActionController::Base.session = {
  :key         => '_filesystem1_session',
  :secret      => '310fb1a3ca70137c19778a0d2f6af47dbc4e11004a51963d8c1d4515889c52813126381ed8cee6b2e77750bb9bd2e003b69a0d1fa2b1cce45103f1a7464d1bae'
}

# Use the database for sessions instead of the cookie-based default,
# which shouldn't be used to store highly confidential information
# (create the session table with "rake db:sessions:create")
# ActionController::Base.session_store = :active_record_store
