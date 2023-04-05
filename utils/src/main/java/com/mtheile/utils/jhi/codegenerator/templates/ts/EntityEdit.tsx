import * as React from 'react';
import { Edit, SaveButton, SimpleForm, TextInput, Toolbar } from 'react-admin';
import PageTitle from 'app/litho-ui/shared/components/PageTitle/PageTitle';

export const EntityEdit = props => {
  return (
    <>
      <Edit
        {...props}
        undoable={false}
        title={
          <PageTitle>
            {record => (
              <>
                Person "<strong>{record.name}</strong>"
              </>
            )}
          </PageTitle>
        }
      >
        <SimpleForm toolbar={<ThisToolbar />}>
          <TextInput variant="outlined" inputProps={{ autocomplete: 'off' }} label="name" source="name" />
          <TextInput variant="outlined" inputProps={{ autocomplete: 'off' }} label="Description" source="description" />
        </SimpleForm>
      </Edit>
    </>
  );
};

const ThisToolbar = props => (
  <Toolbar {...props}>
    <SaveButton label="Save" redirect="list" submitOnEnter />
  </Toolbar>
);
