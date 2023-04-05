import React from 'react';
import { TextInput } from 'react-admin';

export const EntityCreateFields = () => {
  return (
    <>
      <br />
      <TextInput variant="outlined" inputProps={{ autocomplete: 'off' }} label="Name" source="name" />
      <TextInput variant="outlined" inputProps={{ autocomplete: 'off' }} label="Description" source="description" />
      <br />
    </>
  );
};
